package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.CourseCategory
import com.example.data.model.StudyMaterial
import com.example.data.model.Subject
import com.example.data.model.TUCoursePaper
import com.example.data.model.TUQuestion
import com.example.ui.components.TuExamAnswerFormatterCard
import com.example.ui.theme.CleanBorder
import com.example.ui.theme.CleanPureWhite
import com.example.ui.theme.CleanSurfaceVariant
import com.example.ui.theme.HighlightAmber
import com.example.ui.theme.HighlightAmberLight
import com.example.ui.theme.HighlightBlue
import com.example.ui.theme.HighlightBlueDark
import com.example.ui.theme.HighlightBlueLight
import com.example.ui.theme.HighlightGreen
import com.example.ui.theme.HighlightGreenDark
import com.example.ui.theme.HighlightGreenLight
import com.example.ui.theme.HighlightPurple
import com.example.ui.theme.HighlightPurpleDark
import com.example.ui.theme.HighlightPurpleLight
import com.example.ui.theme.HighlightRed
import com.example.ui.theme.HighlightRedDark
import com.example.ui.theme.HighlightRedLight
import com.example.ui.theme.TextBlack
import com.example.ui.theme.TextDarkGray
import com.example.ui.theme.TextMutedGray
import com.example.ui.viewmodel.PomodoroSprintType
import com.example.ui.viewmodel.StudyViewModel

/**
 * Main Home & Course Screen structured strictly as requested:
 * Step 1: Choose Academic Year Tab (1st Year, 2nd Year, 3rd Year, 4th Year)
 * Step 2: Show all 5 Subjects for that selected Year
 * Step 3: Show detailed Study Materials, Notes, Unit Syllabus, and TU Board Questions for that Subject!
 */
@Composable
fun DayPlanScreen(
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val selectedYear by viewModel.selectedYearFilter.collectAsState()
    val activeYear = selectedYear ?: 1

    val allCurriculums = viewModel.getTu4YearCurriculum()
    val currentYearCurriculum = allCurriculums.find { it.yearNumber == activeYear } ?: allCurriculums.first()

    val isEmergencyActive by viewModel.isEmergencyModeActive.collectAsState()
    val isNepaliMode by viewModel.isNepaliLanguageActive.collectAsState()
    val timerSeconds by viewModel.timerSecondsLeft.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()
    val pomodoroType by viewModel.pomodoroSprintType.collectAsState()

    var showSprintTimerCard by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CleanPureWhite)
            .testTag("day_plan_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // ======================== STEP 1: CHOOSE ACADEMIC YEAR TABS ========================
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = if (isNepaliMode) "१. स्नातक तह छनोट गर्नुहोस्" else "1. Choose Academic Year",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = HighlightBlueDark,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = if (isNepaliMode) "त्रि.वि. ४-वर्षे पाठ्यक्रम अनुसार अध्ययन" else "Tribhuvan University 4-Year B.A. Program",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = HighlightBlueLight,
                        border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.3f)),
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { showSprintTimerCard = !showSprintTimerCard }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Timer,
                                contentDescription = null,
                                tint = HighlightBlueDark,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (showSprintTimerCard) "Hide Timer" else "1-Hr Sprint",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = HighlightBlueDark
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 4 Interactive Year Tabs (1st Year, 2nd Year, 3rd Year, 4th Year)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val yearTabs = listOf(
                        Triple(1, "1st Year", "5 Subjects"),
                        Triple(2, "2nd Year", "5 Subjects"),
                        Triple(3, "3rd Year", "5 Subjects"),
                        Triple(4, "4th Year", "5 Subjects")
                    )

                    yearTabs.forEach { (yearNumber, label, sub) ->
                        val isSelected = activeYear == yearNumber
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSelected) HighlightBlue else CleanPureWhite,
                            border = androidx.compose.foundation.BorderStroke(
                                width = if (isSelected) 2.dp else 1.dp,
                                color = if (isSelected) HighlightBlue else CleanBorder
                            ),
                            shadowElevation = if (isSelected) 3.dp else 0.dp,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .clickable {
                                    viewModel.setYearFilter(yearNumber)
                                }
                                .testTag("btn_choose_year_$yearNumber")
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isSelected) Color.White else TextBlack
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = sub,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSelected) Color.White.copy(alpha = 0.9f) else TextDarkGray
                                )
                            }
                        }
                    }
                }
            }
        }

        // Optional 1-Hour Sprint Timer Card (Collapsible)
        if (showSprintTimerCard) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "⏱️ 1-Hour TU Study Sprint Timer",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextBlack
                                )
                                Text(
                                    text = "45m Deep Reading + 15m Board Questions Solve",
                                    fontSize = 10.5.sp,
                                    color = TextDarkGray
                                )
                            }

                            val minutes = timerSeconds / 60
                            val seconds = timerSeconds % 60
                            val timeStr = String.format("%02d:%02d", minutes, seconds)

                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isTimerRunning) HighlightGreenLight else CleanSurfaceVariant
                            ) {
                                Text(
                                    text = timeStr,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isTimerRunning) HighlightGreenDark else TextBlack,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(
                                onClick = {
                                    if (isTimerRunning) viewModel.pauseTimer() else viewModel.startTimer(1)
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = if (isTimerRunning) HighlightAmber else HighlightBlue),
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = if (isTimerRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(if (isTimerRunning) "Pause" else "Start Sprint", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                            }

                            OutlinedButton(
                                onClick = { viewModel.resetTimer() },
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Icon(imageVector = Icons.Default.Refresh, contentDescription = null, tint = TextDarkGray, modifier = Modifier.size(15.dp))
                            }
                        }
                    }
                }
            }
        }

        // Active Year Info Card Banner
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = HighlightBlueLight.copy(alpha = 0.5f)),
                border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.3f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                shape = CircleShape,
                                color = HighlightBlue,
                                modifier = Modifier.size(20.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text("$activeYear", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${currentYearCurriculum.yearLabel} (${currentYearCurriculum.subtitle})",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = HighlightBlueDark
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = currentYearCurriculum.description,
                            fontSize = 11.sp,
                            color = TextDarkGray,
                            lineHeight = 14.sp
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = CleanPureWhite,
                        border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = "500 Marks",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        }

        // ======================== STEP 2: SHOW ALL 5 SUBJECTS ========================
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isNepaliMode) "२. विषय छनोट गरी सामग्री हेर्नुहोस् (५ वटा विषय)" else "2. All 5 Subjects in Year $activeYear (Tap to expand notes):",
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextBlack
                )
                Text(
                    text = "100 M Each",
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = HighlightGreenDark
                )
            }
        }

        // Render each of the 5 Subject Cards for the active academic year
        items(currentYearCurriculum.papers) { paper ->
            SubjectCardWithMaterials(
                paper = paper,
                viewModel = viewModel,
                isNepaliMode = isNepaliMode
            )
        }

        // Bottom Universal Blueprint Card
        item {
            Spacer(modifier = Modifier.height(6.dp))
            TuExamAnswerFormatterCard(isExpandedDefault = false)
        }
    }
}

/**
 * ======================== STEP 3: SUBJECT CARD WITH ITS STUDY MATERIALS ========================
 * Displays the subject, its full 5-unit syllabus, its assigned study materials/notes,
 * and direct TU past board questions!
 */
@Composable
fun SubjectCardWithMaterials(
    paper: TUCoursePaper,
    viewModel: StudyViewModel,
    isNepaliMode: Boolean
) {
    var isExpanded by remember { mutableStateOf(true) }

    val categoryColor = when (paper.category) {
        CourseCategory.COMPULSORY -> HighlightAmber
        CourseCategory.RURAL_DEVELOPMENT_MAJOR -> HighlightGreen
        CourseCategory.SOCIOLOGY_MAJOR -> HighlightPurple
        CourseCategory.PRACTICUM_RESEARCH -> HighlightBlue
    }

    val categoryBgLight = when (paper.category) {
        CourseCategory.COMPULSORY -> HighlightAmberLight
        CourseCategory.RURAL_DEVELOPMENT_MAJOR -> HighlightGreenLight
        CourseCategory.SOCIOLOGY_MAJOR -> HighlightPurpleLight
        CourseCategory.PRACTICUM_RESEARCH -> HighlightBlueLight
    }

    // Retrieve study materials and questions for this specific course
    val courseMaterials = viewModel.getMaterialsForCourse(paper.courseCode)
    val courseQuestions = viewModel.getQuestionsForCourse(paper.courseCode)
    val progressPercent = viewModel.getUnitCompletionPercentage(paper.courseCode, paper.units.size)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("subject_card_${paper.courseCode}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, if (isExpanded) categoryColor.copy(alpha = 0.6f) else CleanBorder)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Subject Header Row (Clickable to expand / collapse)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { isExpanded = !isExpanded },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = categoryBgLight,
                        border = androidx.compose.foundation.BorderStroke(1.dp, categoryColor.copy(alpha = 0.4f))
                    ) {
                        Text(
                            text = paper.courseCode,
                            color = categoryColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(
                            text = paper.title,
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Text(
                            text = paper.nepaliTitle,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = HighlightGreenDark
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = if (progressPercent >= 60) HighlightGreenLight else HighlightBlueLight
                    ) {
                        Text(
                            text = "$progressPercent% Ready",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (progressPercent >= 60) HighlightGreenDark else HighlightBlueDark,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = "Expand",
                        tint = TextDarkGray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Expanded Details: Study Materials, 5 Units, Questions
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    // Quick Paper Stats Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = CleanSurfaceVariant,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "🎯 Full Marks: ${paper.fullMarks} (Pass: ${paper.passMarks})",
                                fontSize = 10.5.sp,
                                color = TextDarkGray,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = CleanSurfaceVariant,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "⏱️ ${paper.creditHours}",
                                fontSize = 10.5.sp,
                                color = TextDarkGray,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // ======================== 3A. STUDY MATERIAL & LECTURE NOTES ========================
                    Text(
                        text = "📚 STUDY MATERIALS & LECTURE NOTES FOR ${paper.courseCode}:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = HighlightBlueDark,
                        letterSpacing = 0.5.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    if (courseMaterials.isEmpty()) {
                        // General placeholder note for this subject
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            colors = CardDefaults.cardColors(containerColor = CleanSurfaceVariant)
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = "${paper.title} - Complete Lecture Material",
                                    fontSize = 12.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextBlack
                                )
                                Text(
                                    text = paper.description,
                                    fontSize = 11.sp,
                                    color = TextDarkGray,
                                    lineHeight = 15.sp
                                )
                            }
                        }
                    } else {
                        courseMaterials.forEach { mat ->
                            val isDownloaded = viewModel.isDownloaded(mat.id)
                            val isBookmarked = viewModel.isMaterialBookmarked(mat.id)

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp)
                                    .clickable { viewModel.openMaterial(mat.id) },
                                shape = RoundedCornerShape(8.dp),
                                colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                                border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = mat.title,
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = TextBlack,
                                                maxLines = 1
                                            )
                                            if (isDownloaded) {
                                                Spacer(modifier = Modifier.width(4.dp))
                                                Icon(
                                                    imageVector = Icons.Default.CloudDone,
                                                    contentDescription = "Downloaded",
                                                    tint = HighlightGreen,
                                                    modifier = Modifier.size(13.dp)
                                                )
                                            }
                                        }

                                        mat.nepaliSubtitle?.let {
                                            Text(
                                                text = it,
                                                fontSize = 10.5.sp,
                                                color = HighlightGreenDark
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(2.dp))

                                        Text(
                                            text = "⏱️ ${mat.estimatedReadMinutes} min • ${mat.authorOrSource}",
                                            fontSize = 10.sp,
                                            color = TextMutedGray
                                        )
                                    }

                                    Button(
                                        onClick = { viewModel.openMaterial(mat.id) },
                                        shape = RoundedCornerShape(6.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                                    ) {
                                        Icon(imageVector = Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(12.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Read Note", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // ======================== 3B. 5-UNIT SYLLABUS REVISION CHECKLIST ========================
                    Text(
                        text = "📋 5-UNIT SYLLABUS CHECKLIST (Tap to mark revised):",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = HighlightGreenDark,
                        letterSpacing = 0.5.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    paper.units.forEachIndexed { unitIdx, unitText ->
                        val unitNum = unitIdx + 1
                        val isUnitDone = viewModel.isUnitCompleted(paper.courseCode, unitNum)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (isUnitDone) HighlightGreenLight.copy(alpha = 0.4f) else CleanSurfaceVariant.copy(alpha = 0.4f))
                                .clickable { viewModel.toggleUnitCompletion(paper.courseCode, unitNum) }
                                .padding(horizontal = 8.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = if (isUnitDone) Icons.Default.CheckCircle else Icons.Outlined.CheckCircleOutline,
                                contentDescription = null,
                                tint = if (isUnitDone) HighlightGreen else TextMutedGray,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = unitText,
                                fontSize = 11.sp,
                                fontWeight = if (isUnitDone) FontWeight.Bold else FontWeight.Normal,
                                color = if (isUnitDone) HighlightGreenDark else TextBlack,
                                lineHeight = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                    }

                    // Key Thinkers / Acts Chips
                    if (paper.keyThinkersOrActs.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            paper.keyThinkersOrActs.forEach { act ->
                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = categoryBgLight
                                ) {
                                    Text(
                                        text = "★ $act",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = categoryColor,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // ======================== 3C. TU BOARD PAST QUESTIONS FOR THIS SUBJECT ========================
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🎯 TU BOARD EXAM QUESTIONS (${courseQuestions.size}):",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = HighlightRedDark,
                            letterSpacing = 0.5.sp
                        )

                        Text(
                            text = "Group A, B, C",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDarkGray
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    if (courseQuestions.isEmpty()) {
                        OutlinedButton(
                            onClick = { viewModel.selectTab(com.example.ui.viewmodel.AppTab.EXAM) },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(imageVector = Icons.Default.Quiz, contentDescription = null, tint = HighlightBlueDark, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Practice Model Exam for ${paper.courseCode}", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = HighlightBlueDark)
                        }
                    } else {
                        courseQuestions.take(2).forEach { q ->
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = HighlightRedLight.copy(alpha = 0.4f),
                                border = androidx.compose.foundation.BorderStroke(1.dp, HighlightRed.copy(alpha = 0.3f)),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp)
                                    .clickable {
                                        if (q.questionType == com.example.data.model.QuestionType.MCQ) {
                                            viewModel.startMcqExam(q.subject)
                                        } else {
                                            viewModel.openSubjectiveExam(q.id)
                                        }
                                    }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "${q.tuYearAsked} • ${q.questionType.label} (${q.marks}M)",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = HighlightRedDark
                                        )
                                        Text(
                                            text = q.questionText,
                                            fontSize = 11.5.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = TextBlack,
                                            maxLines = 2
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "Solve →",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = HighlightBlueDark
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
