package com.example.data.repository

import com.example.data.database.AppDatabase
import com.example.data.database.BookmarkEntity
import com.example.data.database.ExamAttemptEntity
import com.example.data.database.ReadingDayProgressEntity
import com.example.data.database.UserNoteEntity
import com.example.data.mock.TuCurriculumData
import com.example.data.model.DayPlan
import com.example.data.model.MaterialType
import com.example.data.model.StudyMaterial
import com.example.data.model.Subject
import com.example.data.model.TUQuestion
import kotlinx.coroutines.flow.Flow

class StudyRepository(private val database: AppDatabase) {

    private val readingDao = database.readingProgressDao()
    private val bookmarkDao = database.bookmarkDao()
    private val examAttemptDao = database.examAttemptDao()
    private val noteDao = database.userNoteDao()

    fun getAllMaterials(): List<StudyMaterial> = TuCurriculumData.studyMaterials

    fun getMaterialById(id: String): StudyMaterial? {
        return TuCurriculumData.studyMaterials.find { it.id == id }
    }

    fun getMaterialsBySubject(subject: Subject): List<StudyMaterial> {
        return TuCurriculumData.studyMaterials.filter { it.subject == subject || it.subject == Subject.INTERDISCIPLINARY }
    }

    fun getMaterialsByType(type: MaterialType): List<StudyMaterial> {
        return TuCurriculumData.studyMaterials.filter { it.type == type }
    }

    fun getAllDayPlans(): List<DayPlan> = TuCurriculumData.sixteenDayPlans

    fun getDayPlan(dayNumber: Int): DayPlan? {
        return TuCurriculumData.sixteenDayPlans.find { it.dayNumber == dayNumber }
    }

    fun getAllQuestions(): List<TUQuestion> = TuCurriculumData.tuQuestions

    fun getQuestionsBySubject(subject: Subject): List<TUQuestion> {
        return TuCurriculumData.tuQuestions.filter { it.subject == subject }
    }

    fun getMcqQuestions(): List<TUQuestion> {
        return TuCurriculumData.tuQuestions.filter { it.questionType == com.example.data.model.QuestionType.MCQ }
    }

    fun getSubjectiveQuestions(): List<TUQuestion> {
        return TuCurriculumData.tuQuestions.filter { it.questionType != com.example.data.model.QuestionType.MCQ }
    }

    fun getQuestionById(id: String): TUQuestion? {
        return TuCurriculumData.tuQuestions.find { it.id == id }
    }

    fun getTu4YearCurriculum(): List<com.example.data.model.TUYearSyllabus> = TuCurriculumData.tu4YearCurriculumList

    fun getCurriculumByYear(year: Int): com.example.data.model.TUYearSyllabus? {
        return TuCurriculumData.tu4YearCurriculumList.find { it.yearNumber == year }
    }

    fun getBilingualGlossary(): List<com.example.data.model.BilingualGlossaryItem> = TuCurriculumData.bilingualGlossary

    fun getEmergencyCheats(): List<com.example.data.model.HighYieldEmergencyCheat> = TuCurriculumData.emergencyCheats

    val readingProgressFlow: Flow<List<ReadingDayProgressEntity>> = readingDao.getAllProgress()
    val bookmarksFlow: Flow<List<BookmarkEntity>> = bookmarkDao.getAllBookmarks()
    val examAttemptsFlow: Flow<List<ExamAttemptEntity>> = examAttemptDao.getAllAttempts()
    val userNotesFlow: Flow<List<UserNoteEntity>> = noteDao.getAllNotes()

    suspend fun setDayCompleted(dayNumber: Int, completed: Boolean) {
        val existing = readingDao.getProgressForDay(dayNumber)
        if (existing == null) {
            readingDao.insertOrUpdateProgress(
                ReadingDayProgressEntity(
                    dayNumber = dayNumber,
                    isCompleted = completed,
                    minutesSpent = if (completed) 60 else 0,
                    completedTimestamp = if (completed) System.currentTimeMillis() else null
                )
            )
        } else {
            readingDao.setDayCompleted(
                dayNumber = dayNumber,
                completed = completed,
                timestamp = if (completed) System.currentTimeMillis() else null
            )
        }
    }

    suspend fun addStudyMinutes(dayNumber: Int, minutes: Int) {
        val existing = readingDao.getProgressForDay(dayNumber)
        if (existing == null) {
            readingDao.insertOrUpdateProgress(
                ReadingDayProgressEntity(
                    dayNumber = dayNumber,
                    isCompleted = minutes >= 60,
                    minutesSpent = minutes,
                    completedTimestamp = if (minutes >= 60) System.currentTimeMillis() else null
                )
            )
        } else {
            readingDao.addMinutesSpent(dayNumber, minutes)
        }
    }

    suspend fun toggleBookmark(materialId: String, isCurrentlyBookmarked: Boolean) {
        if (isCurrentlyBookmarked) {
            bookmarkDao.removeBookmark(materialId)
        } else {
            bookmarkDao.addBookmark(BookmarkEntity(materialId = materialId))
        }
    }

    suspend fun recordExamAttempt(attempt: ExamAttemptEntity): Long {
        return examAttemptDao.recordAttempt(attempt)
    }

    suspend fun saveNote(note: UserNoteEntity): Long {
        return if (note.id == 0L) {
            noteDao.insertNote(note)
        } else {
            noteDao.updateNote(note)
            note.id
        }
    }

    suspend fun deleteNote(id: Long) {
        noteDao.deleteNote(id)
    }

    suspend fun resetAllReadingProgress() {
        readingDao.resetAllProgress()
    }
}
