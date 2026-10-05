package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.AppDatabase
import com.example.data.database.BookmarkEntity
import com.example.data.database.ExamAttemptEntity
import com.example.data.database.ReadingDayProgressEntity
import com.example.data.database.UserNoteEntity
import com.example.data.model.AppLanguageMode
import com.example.data.model.BilingualGlossaryItem
import com.example.data.model.DayPlan
import com.example.data.model.HighYieldEmergencyCheat
import com.example.data.model.MaterialType
import com.example.data.model.StudyMaterial
import com.example.data.model.Subject
import com.example.data.model.TUCoursePaper
import com.example.data.model.TUQuestion
import com.example.data.model.TUYearSyllabus
import com.example.data.repository.StudyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class AppTab(val title: String, val nepaliTitle: String) {
    DAY_PLAN("Courses & Study", "पाठ्यक्रम र अध्ययन"),
    MATERIALS("Materials Hub", "सामग्री तथा विषय"),
    EXAM("TU Exam Hall", "त्रि.वि. परीक्षा हल"),
    NOTES("Notes & Stats", "टिपोट र प्रगति")
}

sealed class SubScreen {
    object None : SubScreen()
    data class MaterialDetail(val materialId: String) : SubScreen()
    data class DayDetail(val dayNumber: Int) : SubScreen()
    data class McqSession(val subject: Subject?) : SubScreen()
    data class SubjectiveSession(val questionId: String) : SubScreen()
    data class YearSyllabusDetail(val yearNumber: Int) : SubScreen()
}

enum class PomodoroSprintType(val title: String, val nepaliTitle: String, val durationMinutes: Int) {
    DEEP_READING("45m Deep Reading", "४५ मिनेट गहन अध्ययन", 45),
    QUESTION_PRACTICE("15m Exam Solve", "१५ मिनेट परीक्षा अभ्यास", 15),
    FULL_HOUR("60m Complete Unit", "६० मिनेट पूर्ण एकाइ", 60)
}

class StudyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudyRepository = StudyRepository(AppDatabase.getDatabase(application))

    private val _selectedTab = MutableStateFlow(AppTab.MATERIALS)
    val selectedTab: StateFlow<AppTab> = _selectedTab.asStateFlow()

    private val _subScreen = MutableStateFlow<SubScreen>(SubScreen.None)
    val subScreen: StateFlow<SubScreen> = _subScreen.asStateFlow()

    val readingProgress: StateFlow<List<ReadingDayProgressEntity>> = repository.readingProgressFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val bookmarks: StateFlow<List<BookmarkEntity>> = repository.bookmarksFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val examAttempts: StateFlow<List<ExamAttemptEntity>> = repository.examAttemptsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val userNotes: StateFlow<List<UserNoteEntity>> = repository.userNotesFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // 1. ⚡ 24-Hour Emergency Mode State
    private val _isEmergencyModeActive = MutableStateFlow(false)
    val isEmergencyModeActive: StateFlow<Boolean> = _isEmergencyModeActive.asStateFlow()

    // 2. 🇳🇵 Instant Bilingual Switch (English ⇄ Nepali ⇄ Dual)
    private val _appLanguageMode = MutableStateFlow(AppLanguageMode.BILINGUAL)
    val appLanguageMode: StateFlow<AppLanguageMode> = _appLanguageMode.asStateFlow()

    private val _isNepaliLanguageActive = MutableStateFlow(true)
    val isNepaliLanguageActive: StateFlow<Boolean> = _isNepaliLanguageActive.asStateFlow()

    // 3. 📝 "How to Score 70%+ in TU Exam" Answer Structure Guide Modal
    private val _showAnswerStructureDialog = MutableStateFlow(false)
    val showAnswerStructureDialog: StateFlow<Boolean> = _showAnswerStructureDialog.asStateFlow()

    // 4. ⏱️ Pomodoro "1-Hour TU Study Sprint"
    private val _pomodoroSprintType = MutableStateFlow(PomodoroSprintType.DEEP_READING)
    val pomodoroSprintType: StateFlow<PomodoroSprintType> = _pomodoroSprintType.asStateFlow()

    private val _activeTimerDay = MutableStateFlow<Int?>(1)
    val activeTimerDay: StateFlow<Int?> = _activeTimerDay.asStateFlow()

    private val _timerSecondsLeft = MutableStateFlow(45 * 60)
    val timerSecondsLeft: StateFlow<Int> = _timerSecondsLeft.asStateFlow()

    private val _isTimerRunning = MutableStateFlow(false)
    val isTimerRunning: StateFlow<Boolean> = _isTimerRunning.asStateFlow()

    private var timerJob: Job? = null

    // 5. 🔍 4-Year Academic Year Filter & Subject Selector (Default Year 1, Course null = all 5)
    private val _selectedYearFilter = MutableStateFlow<Int?>(1)
    val selectedYearFilter: StateFlow<Int?> = _selectedYearFilter.asStateFlow()

    private val _selectedCourseCodeFilter = MutableStateFlow<String?>("C.Eng. 401")
    val selectedCourseCodeFilter: StateFlow<String?> = _selectedCourseCodeFilter.asStateFlow()

    private val _selectedSubjectFilter = MutableStateFlow<Subject?>(null)
    val selectedSubjectFilter: StateFlow<Subject?> = _selectedSubjectFilter.asStateFlow()

    private val _selectedTypeFilter = MutableStateFlow<MaterialType?>(null)
    val selectedTypeFilter: StateFlow<MaterialType?> = _selectedTypeFilter.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _filterOnlyBookmarked = MutableStateFlow(false)
    val filterOnlyBookmarked: StateFlow<Boolean> = _filterOnlyBookmarked.asStateFlow()

    // 6. 📊 Visual Progress Donut & Topic Checklist (5 Units per course)
    private val _completedUnits = MutableStateFlow<Map<String, Set<Int>>>(
        mapOf(
            "RD 421" to setOf(1, 2),
            "SOC 421" to setOf(1),
            "C.Eng. 401" to setOf(1, 2, 3)
        )
    )
    val completedUnits: StateFlow<Map<String, Set<Int>>> = _completedUnits.asStateFlow()

    // 7. 📑 Quick PDF / Offline Downloaded Tracking
    private val _downloadedMaterialIds = MutableStateFlow<Set<String>>(setOf("rd_mat_01", "soc_mat_01", "eng_mat_01"))
    val downloadedMaterialIds: StateFlow<Set<String>> = _downloadedMaterialIds.asStateFlow()

    // Glossary Modal
    private val _showGlossaryDialog = MutableStateFlow(false)
    val showGlossaryDialog: StateFlow<Boolean> = _showGlossaryDialog.asStateFlow()

    private val _readerFontSize = MutableStateFlow(16)
    val readerFontSize: StateFlow<Int> = _readerFontSize.asStateFlow()

    private val _mcqCurrentIndex = MutableStateFlow(0)
    val mcqCurrentIndex: StateFlow<Int> = _mcqCurrentIndex.asStateFlow()

    private val _mcqAnswers = MutableStateFlow<Map<String, Int>>(emptyMap())
    val mcqAnswers: StateFlow<Map<String, Int>> = _mcqAnswers.asStateFlow()

    private val _mcqSubmitted = MutableStateFlow(false)
    val mcqSubmitted: StateFlow<Boolean> = _mcqSubmitted.asStateFlow()

    private val _subjectiveDraftAnswer = MutableStateFlow("")
    val subjectiveDraftAnswer: StateFlow<String> = _subjectiveDraftAnswer.asStateFlow()

    private val _showModelAnswer = MutableStateFlow(false)
    val showModelAnswer: StateFlow<Boolean> = _showModelAnswer.asStateFlow()

    private val _rubricScores = MutableStateFlow<Map<String, Double>>(emptyMap())
    val rubricScores: StateFlow<Map<String, Double>> = _rubricScores.asStateFlow()

    private val _subjectiveSavedResult = MutableStateFlow(false)
    val subjectiveSavedResult: StateFlow<Boolean> = _subjectiveSavedResult.asStateFlow()

    private val _editingNote = MutableStateFlow<UserNoteEntity?>(null)
    val editingNote: StateFlow<UserNoteEntity?> = _editingNote.asStateFlow()

    private val _showNoteDialog = MutableStateFlow(false)
    val showNoteDialog: StateFlow<Boolean> = _showNoteDialog.asStateFlow()

    // Tab & Navigation
    fun selectTab(tab: AppTab) {
        _selectedTab.value = tab
        _subScreen.value = SubScreen.None
    }

    fun openMaterial(materialId: String) {
        _subScreen.value = SubScreen.MaterialDetail(materialId)
    }

    fun openDayPlan(dayNumber: Int) {
        _subScreen.value = SubScreen.DayDetail(dayNumber)
    }

    fun startMcqExam(subject: Subject?) {
        _mcqCurrentIndex.value = 0
        _mcqAnswers.value = emptyMap()
        _mcqSubmitted.value = false
        _subScreen.value = SubScreen.McqSession(subject)
    }

    fun openSubjectiveExam(questionId: String) {
        _subjectiveDraftAnswer.value = ""
        _showModelAnswer.value = false
        _rubricScores.value = emptyMap()
        _subjectiveSavedResult.value = false
        _subScreen.value = SubScreen.SubjectiveSession(questionId)
    }

    fun openYearSyllabusDetail(yearNumber: Int) {
        _selectedYearFilter.value = yearNumber
        _subScreen.value = SubScreen.YearSyllabusDetail(yearNumber)
    }

    fun openYearSyllabus(year: Int) = openYearSyllabusDetail(year)

    fun navigateBack(): Boolean {
        if (_subScreen.value !is SubScreen.None) {
            _subScreen.value = SubScreen.None
            return true
        }
        return false
    }

    // 1. Emergency Mode Controls
    fun toggleEmergencyMode() {
        _isEmergencyModeActive.value = !_isEmergencyModeActive.value
    }

    // 2. Bilingual Controls
    fun setLanguageMode(mode: AppLanguageMode) {
        _appLanguageMode.value = mode
        _isNepaliLanguageActive.value = (mode == AppLanguageMode.NEPALI || mode == AppLanguageMode.BILINGUAL)
    }

    fun cycleLanguageMode() {
        val next = when (_appLanguageMode.value) {
            AppLanguageMode.ENGLISH -> AppLanguageMode.NEPALI
            AppLanguageMode.NEPALI -> AppLanguageMode.BILINGUAL
            AppLanguageMode.BILINGUAL -> AppLanguageMode.ENGLISH
        }
        setLanguageMode(next)
    }

    fun toggleNepaliLanguage() {
        if (_appLanguageMode.value == AppLanguageMode.ENGLISH) {
            setLanguageMode(AppLanguageMode.NEPALI)
        } else {
            setLanguageMode(AppLanguageMode.ENGLISH)
        }
    }

    fun setGlossaryDialogVisible(visible: Boolean) {
        _showGlossaryDialog.value = visible
    }

    // 3. Answer Guide Dialog
    fun setAnswerStructureDialogVisible(visible: Boolean) {
        _showAnswerStructureDialog.value = visible
    }

    // 4. Pomodoro Sprint Controls
    fun selectPomodoroSprint(type: PomodoroSprintType) {
        _pomodoroSprintType.value = type
        pauseTimer()
        _timerSecondsLeft.value = type.durationMinutes * 60
    }

    fun startTimer(dayNumber: Int) {
        _activeTimerDay.value = dayNumber
        if (_isTimerRunning.value) return
        _isTimerRunning.value = true

        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_isTimerRunning.value && _timerSecondsLeft.value > 0) {
                delay(1000)
                _timerSecondsLeft.value -= 1
            }
            if (_timerSecondsLeft.value <= 0) {
                _isTimerRunning.value = false
                val minutesDone = _pomodoroSprintType.value.durationMinutes
                repository.addStudyMinutes(dayNumber, minutesDone)
                if (minutesDone >= 45) {
                    repository.setDayCompleted(dayNumber, true)
                }
            }
        }
    }

    fun startDailyTimer(dayNumber: Int) = startTimer(dayNumber)

    fun pauseTimer() {
        _isTimerRunning.value = false
        timerJob?.cancel()
    }

    fun resetTimer() {
        pauseTimer()
        _timerSecondsLeft.value = _pomodoroSprintType.value.durationMinutes * 60
    }

    // 5. Universal Filters & 3-Step Selection
    fun setYearFilter(year: Int?) {
        _selectedYearFilter.value = year
        if (year != null) {
            val papers = getPapersForYear(year)
            _selectedCourseCodeFilter.value = papers.firstOrNull()?.courseCode
        } else {
            _selectedCourseCodeFilter.value = null
        }
    }

    fun selectSubject(courseCode: String?) {
        _selectedCourseCodeFilter.value = courseCode
    }

    fun setSubjectFilter(subject: Subject?) {
        _selectedSubjectFilter.value = subject
    }

    fun setTypeFilter(type: MaterialType?) {
        _selectedTypeFilter.value = type
    }

    fun setCourseCodeFilter(code: String?) {
        _selectedCourseCodeFilter.value = code
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun toggleOnlyBookmarked() {
        _filterOnlyBookmarked.value = !_filterOnlyBookmarked.value
    }

    fun openMaterialsForCourse(courseCode: String, academicYear: Int) {
        _selectedYearFilter.value = academicYear
        _selectedCourseCodeFilter.value = courseCode
        _selectedTab.value = AppTab.MATERIALS
        _subScreen.value = SubScreen.None
    }

    // 6. Unit Completion Tracking
    fun toggleUnitCompletion(courseCode: String, unitNumber: Int) {
        val currentMap = _completedUnits.value.toMutableMap()
        val currentSet = (currentMap[courseCode] ?: emptySet()).toMutableSet()
        if (currentSet.contains(unitNumber)) {
            currentSet.remove(unitNumber)
        } else {
            currentSet.add(unitNumber)
        }
        currentMap[courseCode] = currentSet
        _completedUnits.value = currentMap
    }

    fun isUnitCompleted(courseCode: String, unitNumber: Int): Boolean {
        return _completedUnits.value[courseCode]?.contains(unitNumber) == true
    }

    fun getUnitCompletionPercentage(courseCode: String, totalUnits: Int = 5): Int {
        val completedCount = _completedUnits.value[courseCode]?.size ?: 0
        return ((completedCount.toDouble() / totalUnits.toDouble()) * 100).toInt().coerceIn(0, 100)
    }

    // 7. Offline Download Simulation
    fun toggleDownload(materialId: String) {
        val current = _downloadedMaterialIds.value.toMutableSet()
        if (current.contains(materialId)) {
            current.remove(materialId)
        } else {
            current.add(materialId)
        }
        _downloadedMaterialIds.value = current
    }

    fun isDownloaded(materialId: String): Boolean = _downloadedMaterialIds.value.contains(materialId)

    // Bookmarks & Database Operations
    fun toggleBookmark(materialId: String) {
        val isBookmarked = isMaterialBookmarked(materialId)
        viewModelScope.launch {
            repository.toggleBookmark(materialId, isBookmarked)
        }
    }

    fun isMaterialBookmarked(materialId: String): Boolean {
        return bookmarks.value.any { it.materialId == materialId }
    }

    fun setDayCompleted(dayNumber: Int, completed: Boolean) {
        viewModelScope.launch {
            repository.setDayCompleted(dayNumber, completed)
        }
    }

    fun toggleDayCompletion(dayNumber: Int) = setDayCompleted(dayNumber, !isDayCompleted(dayNumber))

    fun isDayCompleted(dayNumber: Int): Boolean {
        return readingProgress.value.find { it.dayNumber == dayNumber }?.isCompleted == true
    }

    fun getCompletedDayCount(): Int {
        return readingProgress.value.count { it.isCompleted }
    }

    fun setReaderFontSize(size: Int) {
        _readerFontSize.value = size.coerceIn(12, 28)
    }

    // Curriculum & Material Retrieval
    fun getPapersForYear(year: Int): List<TUCoursePaper> {
        return repository.getCurriculumByYear(year)?.papers ?: emptyList()
    }

    fun getFilteredMaterials(): List<StudyMaterial> {
        val all = repository.getAllMaterials()
        val year = _selectedYearFilter.value
        val code = _selectedCourseCodeFilter.value
        val subject = _selectedSubjectFilter.value
        val type = _selectedTypeFilter.value
        val query = _searchQuery.value.trim().lowercase()
        val onlyBookmarked = _filterOnlyBookmarked.value
        val emergencyOnly = _isEmergencyModeActive.value

        return all.filter { material ->
            val matchEmergency = !emergencyOnly || material.isEmergencyYield || material.estimatedReadMinutes <= 30
            val matchYear = year == null || material.academicYear == year
            val matchCode = code == null ||
                    material.courseCode.equals(code, ignoreCase = true) ||
                    material.courseCode.replace(" ", "").equals(code.replace(" ", ""), ignoreCase = true)
            val matchSubject = subject == null || material.subject == subject || material.subject == Subject.INTERDISCIPLINARY
            val matchType = type == null || material.type == type
            val matchQuery = query.isEmpty() ||
                    material.title.lowercase().contains(query) ||
                    material.courseCode.lowercase().contains(query) ||
                    material.summary.lowercase().contains(query) ||
                    material.examKeywords.any { it.lowercase().contains(query) } ||
                    (material.nepaliSubtitle?.lowercase()?.contains(query) == true)
            val matchBookmark = !onlyBookmarked || isMaterialBookmarked(material.id)

            matchEmergency && matchYear && matchCode && matchSubject && matchType && matchQuery && matchBookmark
        }
    }

    fun getMaterialsForCourse(courseCode: String): List<StudyMaterial> {
        val cleanCode = courseCode.replace("-", "").replace(".", "").replace(" ", "").lowercase()
        return repository.getAllMaterials().filter { mat ->
            val matClean = mat.courseCode.replace("-", "").replace(".", "").replace(" ", "").lowercase()
            matClean == cleanCode
        }
    }

    fun getQuestionsForCourse(courseCode: String): List<TUQuestion> {
        val cleanCode = courseCode.replace("-", "").replace(".", "").replace(" ", "").lowercase()
        return repository.getAllQuestions().filter { q ->
            val qClean = q.courseCode.replace("-", "").replace(".", "").replace(" ", "").lowercase()
            qClean == cleanCode
        }
    }

    // MCQ Exam
    fun answerMcq(questionId: String, selectedOption: Int) {
        if (_mcqSubmitted.value) return
        _mcqAnswers.value = _mcqAnswers.value.toMutableMap().apply {
            put(questionId, selectedOption)
        }
    }

    fun selectMcqOption(questionId: String, optionIndex: Int) = answerMcq(questionId, optionIndex)

    fun prevMcqQuestion() {
        _mcqCurrentIndex.value = (_mcqCurrentIndex.value - 1).coerceAtLeast(0)
    }

    fun nextMcqQuestion(maxSize: Int) {
        _mcqCurrentIndex.value = (_mcqCurrentIndex.value + 1).coerceAtMost(maxSize - 1)
    }

    fun resetMcqExam(subject: Subject?) = startMcqExam(subject)

    fun submitMcqExam(questions: List<TUQuestion>, subjectName: String) {
        _mcqSubmitted.value = true
        var correctCount = 0
        var totalMarks = 0.0
        var scoredMarks = 0.0

        questions.forEach { q ->
            totalMarks += q.marks
            val userAns = _mcqAnswers.value[q.id]
            if (userAns != null && userAns == q.correctOptionIndex) {
                correctCount++
                scoredMarks += q.marks
            }
        }

        val percentage = if (totalMarks > 0) (scoredMarks / totalMarks) * 100 else 0.0
        val division = when {
            percentage >= 80 -> "Distinction"
            percentage >= 60 -> "First Division"
            percentage >= 45 -> "Second Division"
            percentage >= 40 -> "Pass Division"
            else -> "Fail"
        }

        viewModelScope.launch {
            repository.recordExamAttempt(
                ExamAttemptEntity(
                    examTitle = "TU Objective MCQ ($subjectName)",
                    subject = subjectName,
                    mode = "MCQ",
                    totalQuestions = questions.size,
                    correctCount = correctCount,
                    totalMarks = totalMarks,
                    scoredMarks = scoredMarks,
                    percentage = percentage,
                    tuDivision = division,
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }

    // Subjective Exam
    fun updateSubjectiveDraft(draft: String) {
        _subjectiveDraftAnswer.value = draft
    }

    fun updateDraftAnswer(draft: String) = updateSubjectiveDraft(draft)

    fun toggleModelAnswer() {
        _showModelAnswer.value = !_showModelAnswer.value
    }

    fun toggleShowModelAnswer() = toggleModelAnswer()

    fun updateRubricScore(criterionId: String, score: Double) {
        _rubricScores.value = _rubricScores.value.toMutableMap().apply {
            put(criterionId, score)
        }
    }

    fun setRubricScore(criterionId: String, score: Double) = updateRubricScore(criterionId, score)

    fun saveSubjectiveGrade(question: TUQuestion) {
        var totalAwarded = 0.0
        _rubricScores.value.values.forEach { totalAwarded += it }
        val percentage = if (question.marks > 0) (totalAwarded / question.marks) * 100 else 0.0
        val division = when {
            percentage >= 80 -> "Distinction"
            percentage >= 60 -> "First Division"
            percentage >= 45 -> "Second Division"
            percentage >= 40 -> "Pass Division"
            else -> "Fail"
        }

        viewModelScope.launch {
            repository.recordExamAttempt(
                ExamAttemptEntity(
                    examTitle = "TU Subjective Practice (${question.courseCode})",
                    subject = question.subject.displayName,
                    mode = "SUBJECTIVE",
                    totalQuestions = 1,
                    correctCount = if (percentage >= 40) 1 else 0,
                    totalMarks = question.marks.toDouble(),
                    scoredMarks = totalAwarded,
                    percentage = percentage,
                    tuDivision = division,
                    timestamp = System.currentTimeMillis()
                )
            )
            _subjectiveSavedResult.value = true
        }
    }

    fun saveSubjectivePractice(question: TUQuestion) = saveSubjectiveGrade(question)

    // Notes
    fun openNoteEditor(note: UserNoteEntity?) {
        _editingNote.value = note ?: UserNoteEntity(
            title = "",
            subject = "General",
            content = ""
        )
        _showNoteDialog.value = true
    }

    fun closeNoteEditor() {
        _showNoteDialog.value = false
        _editingNote.value = null
    }

    fun saveUserNote(title: String, subject: String, content: String, relatedMaterialId: String? = null) {
        val current = _editingNote.value
        val noteToSave = current?.copy(
            title = title,
            subject = subject,
            content = content,
            relatedMaterialId = relatedMaterialId ?: current.relatedMaterialId,
            updatedAt = System.currentTimeMillis()
        ) ?: UserNoteEntity(
            title = title,
            subject = subject,
            content = content,
            relatedMaterialId = relatedMaterialId
        )

        viewModelScope.launch {
            repository.saveNote(noteToSave)
            closeNoteEditor()
        }
    }

    fun deleteUserNote(id: Long) {
        viewModelScope.launch {
            repository.deleteNote(id)
        }
    }

    // Repository accessors
    fun getAllDayPlans(): List<DayPlan> = repository.getAllDayPlans()
    fun getDayPlan(dayNumber: Int): DayPlan? = repository.getDayPlan(dayNumber)
    fun getAllMaterials(): List<StudyMaterial> = repository.getAllMaterials()
    fun getMaterialById(id: String): StudyMaterial? = repository.getMaterialById(id)
    fun getAllQuestions(): List<TUQuestion> = repository.getAllQuestions()
    fun getQuestionById(id: String): TUQuestion? = repository.getQuestionById(id)
    fun getTu4YearCurriculum(): List<TUYearSyllabus> = repository.getTu4YearCurriculum()
    fun getCurriculumByYear(year: Int): TUYearSyllabus? = repository.getCurriculumByYear(year)
    fun getBilingualGlossary(): List<BilingualGlossaryItem> = repository.getBilingualGlossary()
    fun getEmergencyCheats(): List<HighYieldEmergencyCheat> = repository.getEmergencyCheats()
}
