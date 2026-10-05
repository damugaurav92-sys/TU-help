package com.example.data.model

enum class Subject(val displayName: String, val codePrefix: String, val nepaliDisplayName: String = displayName) {
    RURAL_DEVELOPMENT("Rural Development", "RD", "ग्रामीण विकास"),
    SOCIOLOGY("Sociology", "SOC", "समाजशास्त्र"),
    COMPULSORY_LANGUAGE("Compulsory Language / General", "COMP", "अनिवार्य विषय"),
    INTERDISCIPLINARY("Integrated / Both", "BA", "अन्तरविषयगत")
}

enum class MaterialType(val label: String, val badgeColorHex: Long, val nepaliLabel: String = label) {
    COURSE_MATERIAL("Course Book / Textbook", 0xFF2563EB, "पाठ्यपुस्तक तथा सन्दर्भ ग्रन्थ"),
    LECTURE_NOTE("Lecture Notes & Summary", 0xFF059669, "मुख्य टिपोट तथा सारांश"),
    RESEARCH_PAPER("Nepal Research Paper & Case Study", 0xFF7C3AED, "नेपाल शोधपत्र तथा केस स्टडी")
}

enum class CourseCategory(val label: String, val badgeColorHex: Long, val nepaliLabel: String = label) {
    COMPULSORY("Compulsory Paper", 0xFFD97706, "अनिवार्य पत्र"),
    RURAL_DEVELOPMENT_MAJOR("Rural Development Major", 0xFF059669, "ग्रामीण विकास मुख्य"),
    SOCIOLOGY_MAJOR("Sociology Major", 0xFF7C3AED, "समाजशास्त्र मुख्य"),
    PRACTICUM_RESEARCH("Practicum / Research Thesis", 0xFF2563EB, "प्रयोगात्मक तथा शोधपत्र")
}

data class StudyMaterial(
    val id: String,
    val subject: Subject,
    val academicYear: Int = 1, // 1st, 2nd, 3rd, 4th Year
    val type: MaterialType,
    val courseCode: String,
    val title: String,
    val nepaliSubtitle: String? = null,
    val authorOrSource: String,
    val estimatedReadMinutes: Int,
    val summary: String,
    val nepaliSummary: String? = null,
    val fullContent: String,
    val nepaliFullContent: String? = null,
    val keyTakeaways: List<String>,
    val nepaliKeyTakeaways: List<String> = emptyList(),
    val examKeywords: List<String>,
    val nepalCaseStudyFocus: String? = null,
    val yearOrReference: String = "TU FOHSS Syllabus 2080/2081",
    val dayPlanMapping: Int? = null,
    val isEmergencyYield: Boolean = false,
    val memoryMnemonic: String? = null
)

data class DayPlan(
    val dayNumber: Int,
    val academicYear: Int = 1, // 1st, 2nd, 3rd, 4th Year
    val subject: Subject,
    val title: String,
    val subtitle: String,
    val targetMinutes: Int = 60,
    val unitName: String,
    val overview: String,
    val nepaliOverview: String? = null,
    val coreTopics: List<String>,
    val nepaliCoreTopics: List<String> = emptyList(),
    val materialIds: List<String>,
    val primaryQuestionId: String,
    val tuExamTip: String,
    val nepaliTuExamTip: String? = null
)

enum class QuestionType(val label: String, val defaultMarks: Int, val nepaliLabel: String = label) {
    MCQ("Objective MCQ", 1, "वस्तुगत बहुवैकल्पिक (समूह क)"),
    SHORT_ANSWER("Short Answer (Group B)", 5, "संक्षिप्त उत्तर (समूह ख)"),
    LONG_ANSWER("Long Analytical (Group C)", 10, "लामो विश्लेषणात्मक उत्तर (समूह ग)"),
    CRITICAL_EVALUATION("Critical Synthesis (Special)", 15, "समालोचनात्मक विश्लेषण")
}

data class RubricCriterion(
    val id: String,
    val criterion: String,
    val maxMarks: Double,
    val guidance: String
)

data class TUQuestion(
    val id: String,
    val subject: Subject,
    val academicYear: Int = 1, // 1st, 2nd, 3rd, 4th Year
    val courseCode: String,
    val questionType: QuestionType,
    val tuYearAsked: String,
    val questionText: String,
    val nepaliQuestionText: String? = null,
    val options: List<String>? = null,
    val nepaliOptions: List<String>? = null,
    val correctOptionIndex: Int? = null,
    val marks: Int,
    val modelAnswer: String,
    val nepaliModelAnswer: String? = null,
    val evaluationRubric: List<RubricCriterion> = emptyList(),
    val keyPointsRequired: List<String> = emptyList(),
    val explanation: String = "",
    val nepaliExplanation: String = "",
    val isHighFrequency: Boolean = false
)

data class TUCoursePaper(
    val courseCode: String,
    val title: String,
    val nepaliTitle: String,
    val category: CourseCategory,
    val paperNumber: String,
    val fullMarks: Int = 100,
    val passMarks: Int = 40,
    val creditHours: String = "3 Hours Exam • 100 Marks",
    val major: Subject,
    val description: String,
    val nepaliDescription: String? = null,
    val units: List<String>,
    val nepaliUnits: List<String> = emptyList(),
    val keyThinkersOrActs: List<String>,
    val examFormatSummary: String = "Group A: 10×1m (MCQs) • Group B: 6×5m (Short) • Group C: 4×15m (Long Analytical)"
)

data class TUYearSyllabus(
    val yearNumber: Int,
    val yearLabel: String,
    val nepaliYearLabel: String = yearLabel,
    val totalPapers: Int = 5,
    val totalFullMarks: Int = 500,
    val totalPassMarks: Int = 200,
    val subtitle: String,
    val description: String,
    val papers: List<TUCoursePaper>,
    val keyObjectives: List<String>
)

data class ExamResult(
    val totalQuestions: Int,
    val correctCount: Int,
    val totalMarks: Double,
    val scoredMarks: Double,
    val percentage: Double,
    val gradeText: String,
    val tuDivision: String,
    val feedback: String
)

enum class AppLanguageMode(val label: String, val nepaliLabel: String, val shortCode: String) {
    ENGLISH("English", "अंग्रेजी", "ENG"),
    NEPALI("Nepali", "नेपाली", "NEP"),
    BILINGUAL("Both / Dual", "दुवै (English + नेपाली)", "DUAL")
}

data class BilingualGlossaryItem(
    val id: String,
    val englishTerm: String,
    val nepaliTerm: String,
    val subject: Subject,
    val courseCode: String,
    val definitionEnglish: String,
    val definitionNepali: String,
    val examExample: String
)

data class HighYieldEmergencyCheat(
    val id: String,
    val courseCode: String,
    val subject: Subject,
    val title: String,
    val nepaliTitle: String,
    val highFrequencyQuestion: String,
    val tuYearsAsked: String,
    val coreFormulaOrThinker: String,
    val nepalActOrData: String,
    val quickMemoryPoints: List<String>
)
