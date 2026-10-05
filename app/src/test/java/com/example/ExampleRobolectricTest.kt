package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.mock.TuCurriculumData
import com.example.data.model.CourseCategory
import com.example.data.model.Subject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("TU BA Prep", appName)
    }

    @Test
    fun `verify TU 4-year undergraduate syllabus structure`() {
        val syllabi = TuCurriculumData.tu4YearCurriculumList
        assertEquals(4, syllabi.size)

        // 1st Year verification: 5 subjects (2 RD + 2 SOC + 1 Compulsory English)
        val year1 = syllabi.find { it.yearNumber == 1 }
        assertNotNull(year1)
        assertEquals(5, year1!!.papers.size)
        assertEquals(500, year1.totalFullMarks)

        val compEng = year1.papers.find { it.courseCode == "C.Eng. 401" }
        assertNotNull(compEng)
        assertEquals(CourseCategory.COMPULSORY, compEng!!.category)
        assertEquals(Subject.COMPULSORY_LANGUAGE, compEng.major)

        val rdPapers = year1.papers.filter { it.category == CourseCategory.RURAL_DEVELOPMENT_MAJOR }
        assertEquals(2, rdPapers.size)
        assertTrue(rdPapers.any { it.courseCode == "RD 421" })
        assertTrue(rdPapers.any { it.courseCode == "RD 422" })

        val socPapers = year1.papers.filter { it.category == CourseCategory.SOCIOLOGY_MAJOR }
        assertEquals(2, socPapers.size)
        assertTrue(socPapers.any { it.courseCode == "SOC 421" })
        assertTrue(socPapers.any { it.courseCode == "SOC 422" })
    }

    @Test
    fun `verify study materials across all 4 years and compulsory subjects`() {
        val materials = TuCurriculumData.studyMaterials
        assertTrue(materials.size >= 16)

        // Verify all 4 academic years have study materials
        for (year in 1..4) {
            val yearMaterials = materials.filter { it.academicYear == year }
            assertTrue("Year $year should have study materials", yearMaterials.isNotEmpty())
        }

        // Verify compulsory subjects exist in study materials
        val compulsoryMaterials = materials.filter { it.subject == Subject.COMPULSORY_LANGUAGE }
        assertTrue(compulsoryMaterials.size >= 4)
        assertTrue(compulsoryMaterials.any { it.courseCode == "C.Eng. 401" })
        assertTrue(compulsoryMaterials.any { it.courseCode == "C.Nep. 402" })
        assertTrue(compulsoryMaterials.any { it.courseCode == "C.NepSt. 403" })
        assertTrue(compulsoryMaterials.any { it.courseCode == "C.Eng. 404" })
    }

    @Test
    fun `verify bilingual glossary and emergency high-yield cheats`() {
        val glossary = TuCurriculumData.bilingualGlossary
        assertTrue("Glossary should contain key terms", glossary.size >= 5)
        assertTrue(glossary.any { it.englishTerm.contains("Stratification") })
        assertTrue(glossary.any { it.englishTerm.contains("Participatory Rural Appraisal") })

        val cheats = TuCurriculumData.emergencyCheats
        assertTrue("Emergency cheats should contain high-yield questions", cheats.size >= 4)
        assertTrue(cheats.any { it.courseCode == "RD 421" })
        assertTrue(cheats.any { it.courseCode == "SOC 421" })
    }

    @Test
    fun `verify 16-day study plan structure`() {
        val plan = TuCurriculumData.sixteenDayPlans
        assertEquals(16, plan.size)
        for (i in 0..7) {
            assertEquals(Subject.RURAL_DEVELOPMENT, plan[i].subject)
            assertEquals(60, plan[i].targetMinutes)
        }
        for (i in 8..15) {
            assertEquals(Subject.SOCIOLOGY, plan[i].subject)
            assertEquals(60, plan[i].targetMinutes)
        }
    }
}
