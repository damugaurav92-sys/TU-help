package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.data.model.TUYearSyllabus
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
import com.example.ui.theme.HighlightRedLight
import com.example.ui.theme.TextBlack
import com.example.ui.theme.TextDarkGray
import com.example.ui.theme.TextMutedGray
import com.example.ui.viewmodel.StudyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YearSyllabusDetailScreen(
    initialYear: Int,
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val selectedYear by viewModel.selectedYearFilter.collectAsState()
    val activeYearNumber = selectedYear ?: initialYear
    val allYearCurriculums = viewModel.getTu4YearCurriculum()
    val activeYearSyllabus = allYearCurriculums.find { it.yearNumber == activeYearNumber } ?: allYearCurriculums.first()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "TU 4-Year B.A. Course Structure",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("back_btn_year_syllabus")
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextBlack)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CleanPureWhite)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(CleanPureWhite)
                .padding(innerPadding)
                .testTag("year_syllabus_scroll"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Hero Banner: Tribhuvan University 4-Year Undergraduate Structure
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.6f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = HighlightBlueLight
                            ) {
                                Text(
                                    text = "TRIBHUVAN UNIVERSITY • FoHSS",
                                    color = HighlightBlueDark,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = HighlightGreenLight
                            ) {
                                Text(
                                    text = "Total: 2000 Marks (500/Yr)",
                                    color = HighlightGreenDark,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "${activeYearSyllabus.yearLabel}: Curriculum & Paper Breakdown",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextBlack
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = activeYearSyllabus.description,
                            fontSize = 12.sp,
                            color = TextDarkGray,
                            lineHeight = 16.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Year Selector Segmented Switcher
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            (1..4).forEach { yearNum ->
                                val isSelected = yearNum == activeYearNumber
                                Surface(
                                    shape = RoundedCornerShape(20.dp),
                                    color = if (isSelected) HighlightBlue else CleanPureWhite,
                                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isSelected) HighlightBlue else CleanBorder),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .clickable { viewModel.setYearFilter(yearNum) }
                                        .testTag("year_switch_tab_$yearNum")
                                ) {
                                    Text(
                                        text = "Year $yearNum",
                                        fontSize = 12.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color.White else TextBlack,
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 3. 📝 "How to Score 70%+ in TU Exam" Answer Formatter Card
            item {
                TuExamAnswerFormatterCard(isExpandedDefault = false)
            }

            // Section Header: 5 Subject Papers
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "5 Compulsory & Major Papers (${activeYearSyllabus.totalFullMarks} Marks)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextBlack
                        )
                        Text(
                            text = "Each paper: 100 Marks • Pass Marks: 40 • 5 Units with Revision Checklists",
                            fontSize = 10.5.sp,
                            color = TextDarkGray
                        )
                    }
                }
            }

            // List of all 5 Subject Papers for the active year with 6. 📊 Unit Progress
            items(activeYearSyllabus.papers) { paper ->
                val connectedMaterials = viewModel.getAllMaterials().filter { mat ->
                    mat.courseCode.replace("-", "").replace(".", "").replace(" ", "").equals(
                        paper.courseCode.replace("-", "").replace(".", "").replace(" ", ""),
                        ignoreCase = true
                    )
                }

                DetailedCoursePaperCard(
                    paper = paper,
                    connectedMaterials = connectedMaterials,
                    viewModel = viewModel,
                    onReadNotesClick = {
                        viewModel.openMaterialsForCourse(paper.courseCode, activeYearNumber)
                    },
                    onPracticeExamClick = {
                        viewModel.selectTab(com.example.ui.viewmodel.AppTab.EXAM)
                    },
                    onOpenMaterial = { matId ->
                        viewModel.openMaterial(matId)
                    }
                )
            }
        }
    }
}

@Composable
fun DetailedCoursePaperCard(
    paper: TUCoursePaper,
    connectedMaterials: List<StudyMaterial> = emptyList(),
    viewModel: StudyViewModel,
    onReadNotesClick: () -> Unit,
    onPracticeExamClick: () -> Unit,
    onOpenMaterial: (String) -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }

    val categoryColor = when (paper.category) {
        CourseCategory.COMPULSORY -> HighlightAmber
        CourseCategory.RURAL_DEVELOPMENT_MAJOR -> HighlightGreen
        CourseCategory.SOCIOLOGY_MAJOR -> HighlightPurple
        CourseCategory.PRACTICUM_RESEARCH -> HighlightBlue
    }

    val categoryBg = when (paper.category) {
        CourseCategory.COMPULSORY -> HighlightAmberLight
        CourseCategory.RURAL_DEVELOPMENT_MAJOR -> HighlightGreenLight
        CourseCategory.SOCIOLOGY_MAJOR -> HighlightPurpleLight
        CourseCategory.PRACTICUM_RESEARCH -> HighlightBlueLight
    }

    val progressPercent = viewModel.getUnitCompletionPercentage(paper.courseCode, paper.units.size)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("paper_card_${paper.courseCode}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Course Code & Category Badge & % Ready
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = categoryBg
                    ) {
                        Text(
                            text = "${paper.courseCode} • ${paper.paperNumber}",
                            color = categoryColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = if (progressPercent >= 60) HighlightGreenLight else HighlightBlueLight
                    ) {
                        Text(
                            text = "$progressPercent% Ready",
                            color = if (progressPercent >= 60) HighlightGreenDark else HighlightBlueDark,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = CleanSurfaceVariant
                ) {
                    Text(
                        text = "100 M (Pass: 40)",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = paper.title,
                fontSize = 14.5.sp,
                fontWeight = FontWeight.Bold,
                color = TextBlack
            )

            Text(
                text = paper.nepaliTitle,
                fontSize = 12.sp,
                color = HighlightGreenDark,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 2.dp)
            )

            Text(
                text = paper.description,
                fontSize = 11.5.sp,
                color = TextDarkGray,
                lineHeight = 15.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // 6. 📊 Interactive 5-Unit Checklist with Tap to Complete
            Text(
                text = "5-Unit Syllabus Checklist (Tap to mark revised):",
                fontSize = 10.5.sp,
                fontWeight = FontWeight.Bold,
                color = TextMutedGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            paper.units.forEachIndexed { index, unitText ->
                val unitNum = index + 1
                val isCompleted = viewModel.isUnitCompleted(paper.courseCode, unitNum)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (isCompleted) HighlightGreenLight.copy(alpha = 0.5f) else CleanPureWhite)
                        .clickable { viewModel.toggleUnitCompletion(paper.courseCode, unitNum) }
                        .padding(vertical = 4.dp, horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Outlined.CheckCircleOutline,
                        contentDescription = null,
                        tint = if (isCompleted) HighlightGreen else TextMutedGray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = unitText,
                        fontSize = 11.sp,
                        color = if (isCompleted) HighlightGreenDark else TextBlack,
                        fontWeight = if (isCompleted) FontWeight.SemiBold else FontWeight.Normal,
                        lineHeight = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Action Buttons: Read Notes & Practice Questions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = onReadNotesClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(15.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Read Notes", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = onPracticeExamClick,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(imageVector = Icons.Default.Quiz, contentDescription = null, tint = HighlightBlueDark, modifier = Modifier.size(15.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("TU Exam", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = HighlightBlueDark)
                }
            }
        }
    }
}
