package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Subject
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
import com.example.ui.viewmodel.StudyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayDetailScreen(
    dayNumber: Int,
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val plan = viewModel.getDayPlan(dayNumber) ?: return
    val isCompleted = viewModel.isDayCompleted(dayNumber)
    val timerSeconds by viewModel.timerSecondsLeft.collectAsState()
    val isTimerRunning by viewModel.isTimerRunning.collectAsState()

    val subjectBadgeColor = when (plan.subject) {
        Subject.RURAL_DEVELOPMENT -> HighlightGreen
        Subject.SOCIOLOGY -> HighlightPurple
        Subject.COMPULSORY_LANGUAGE -> HighlightAmber
        Subject.INTERDISCIPLINARY -> HighlightBlue
    }

    val subjectBgLight = when (plan.subject) {
        Subject.RURAL_DEVELOPMENT -> HighlightGreenLight
        Subject.SOCIOLOGY -> HighlightPurpleLight
        Subject.COMPULSORY_LANGUAGE -> HighlightAmberLight
        Subject.INTERDISCIPLINARY -> HighlightBlueLight
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Day $dayNumber: ${plan.unitName}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("back_button_day_detail")
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextBlack)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.setDayCompleted(dayNumber, !isCompleted) },
                        modifier = Modifier.testTag("action_toggle_complete")
                    ) {
                        Icon(
                            imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Outlined.CheckCircleOutline,
                            contentDescription = "Toggle Complete",
                            tint = if (isCompleted) HighlightGreen else TextDarkGray
                        )
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
                .testTag("day_detail_scroll"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Day Header Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.5f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = subjectBgLight
                            ) {
                                Text(
                                    text = plan.subject.displayName,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = subjectBadgeColor,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isCompleted) HighlightGreenLight else CleanSurfaceVariant
                            ) {
                                Text(
                                    text = if (isCompleted) "✓ Completed" else "60 Min Target",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCompleted) HighlightGreenDark else TextBlack,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = plan.title,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextBlack
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = plan.subtitle,
                            fontSize = 12.5.sp,
                            color = TextDarkGray
                        )
                    }
                }
            }

            // Pomodoro Timer for this Day
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val minutes = timerSeconds / 60
                        val seconds = timerSeconds % 60
                        val timeStr = String.format("%02d:%02d", minutes, seconds)

                        Column {
                            Text(
                                text = "Study Sprint Timer",
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextBlack
                            )
                            Text(
                                text = timeStr,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isTimerRunning) HighlightGreenDark else HighlightBlueDark
                            )
                        }

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(
                                onClick = {
                                    if (isTimerRunning) viewModel.pauseTimer() else viewModel.startTimer(dayNumber)
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = if (isTimerRunning) HighlightAmber else HighlightBlue)
                            ) {
                                Icon(
                                    imageVector = if (isTimerRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(if (isTimerRunning) "Pause" else "Start", fontSize = 11.5.sp)
                            }

                            OutlinedButton(
                                onClick = { viewModel.resetTimer() },
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Icon(Icons.Default.Refresh, contentDescription = "Reset", tint = TextDarkGray, modifier = Modifier.size(16.dp))
                            }
                        }
                    }
                }
            }

            // 3. 📝 "How to Score 70%+ in TU Exam" Answer Formatter
            item {
                TuExamAnswerFormatterCard(isExpandedDefault = false)
            }

            // Overview Section
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Unit Conceptual Overview",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = plan.overview,
                            fontSize = 12.sp,
                            color = TextBlack,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // Core Topics Checklist
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Core Curriculum Topics to Master",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        plan.coreTopics.forEach { topic ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = HighlightGreen,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = topic,
                                    fontSize = 11.5.sp,
                                    color = TextBlack,
                                    lineHeight = 15.sp
                                )
                            }
                        }
                    }
                }
            }

            // TU Exam Tip (Red Box)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = HighlightRedLight),
                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightRed.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(imageVector = Icons.Default.Lightbulb, contentDescription = null, tint = HighlightRed, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "💡 TU Board Exam Tip & High-Yield Strategy",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = HighlightRedDark
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = plan.tuExamTip,
                                fontSize = 11.5.sp,
                                color = TextBlack,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }

            // Connected Materials Buttons
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Assigned Study Materials",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )

                    plan.materialIds.forEach { matId ->
                        val mat = viewModel.getMaterialById(matId)
                        if (mat != null) {
                            Button(
                                onClick = { viewModel.openMaterial(matId) },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(imageVector = Icons.Default.MenuBook, contentDescription = null, modifier = Modifier.size(15.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Read: ${mat.title}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1
                                )
                            }
                        }
                    }

                    // Practice Question Button
                    val q = viewModel.getQuestionById(plan.primaryQuestionId)
                    if (q != null) {
                        OutlinedButton(
                            onClick = {
                                if (q.questionType == com.example.data.model.QuestionType.MCQ) {
                                    viewModel.startMcqExam(q.subject)
                                } else {
                                    viewModel.openSubjectiveExam(q.id)
                                }
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(imageVector = Icons.Default.Quiz, contentDescription = null, tint = HighlightBlueDark, modifier = Modifier.size(15.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Practice TU Exam Question (${q.marks} Marks)",
                                fontSize = 12.sp,
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
