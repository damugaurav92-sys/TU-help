package com.example.ui.screens

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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.data.model.QuestionType
import com.example.data.model.Subject
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
import com.example.ui.viewmodel.StudyViewModel

@Composable
fun ExamScreen(
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val allQuestions = viewModel.getAllQuestions()
    var selectedFilterSubject by remember { mutableStateOf<Subject?>(null) }
    var selectedQuestionType by remember { mutableStateOf<QuestionType?>(null) }
    val isEmergencyActive by viewModel.isEmergencyModeActive.collectAsState()
    val isNepaliMode by viewModel.isNepaliLanguageActive.collectAsState()

    val filteredQuestions = allQuestions.filter { q ->
        val matchesEmergency = !isEmergencyActive || q.isHighFrequency || q.questionType == QuestionType.LONG_ANSWER
        val matchesSubject = selectedFilterSubject == null || q.subject == selectedFilterSubject
        val matchesType = selectedQuestionType == null || q.questionType == selectedQuestionType
        matchesEmergency && matchesSubject && matchesType
    }

    val attempts by viewModel.examAttempts.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CleanPureWhite)
            .testTag("exam_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Hero Exam Banner
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("tu_exam_hero_card"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.6f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = HighlightBlueLight
                        ) {
                            Text(
                                text = "TU BOARD EXAM PRACTICE HALL",
                                color = HighlightBlueDark,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = HighlightRedLight
                        ) {
                            Text(
                                text = "100 Marks Model Format",
                                color = HighlightRedDark,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = if (isNepaliMode) "त्रि.वि. बोर्ड परीक्षा प्रश्न बैंक तथा स्व-मूल्यांकन" else "TU Board Question Bank & Evaluation",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextBlack
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Practice Group A (MCQs), Group B (Short Notes), and Group C (Long Analytical) with TU model scoring rubrics.",
                        fontSize = 12.sp,
                        color = TextDarkGray,
                        lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Start Speed MCQ Test Button
                    Button(
                        onClick = { viewModel.startMcqExam(selectedFilterSubject) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("start_speed_test_btn"),
                        colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Start Speed MCQ Exam Test (Group A)",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        // 3. 📝 "How to Score 70%+ in TU Exam" Universal Blueprint
        item {
            TuExamAnswerFormatterCard(isExpandedDefault = false)
        }

        // Filter Chips Row
        item {
            Column {
                Text(
                    text = "FILTER QUESTIONS BY SUBJECT",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMutedGray,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = selectedFilterSubject == null,
                        onClick = { selectedFilterSubject = null },
                        label = { Text("All Subjects", fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = HighlightBlue,
                            selectedLabelColor = Color.White,
                            containerColor = CleanPureWhite,
                            labelColor = TextBlack
                        )
                    )

                    FilterChip(
                        selected = selectedFilterSubject == Subject.RURAL_DEVELOPMENT,
                        onClick = { selectedFilterSubject = Subject.RURAL_DEVELOPMENT },
                        label = { Text("Rural Development", fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = HighlightGreen,
                            selectedLabelColor = Color.White,
                            containerColor = CleanPureWhite,
                            labelColor = TextBlack
                        )
                    )

                    FilterChip(
                        selected = selectedFilterSubject == Subject.SOCIOLOGY,
                        onClick = { selectedFilterSubject = Subject.SOCIOLOGY },
                        label = { Text("Sociology", fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = HighlightPurple,
                            selectedLabelColor = Color.White,
                            containerColor = CleanPureWhite,
                            labelColor = TextBlack
                        )
                    )

                    FilterChip(
                        selected = selectedFilterSubject == Subject.COMPULSORY_LANGUAGE,
                        onClick = { selectedFilterSubject = Subject.COMPULSORY_LANGUAGE },
                        label = { Text("Compulsory", fontSize = 11.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = HighlightAmber,
                            selectedLabelColor = Color.White,
                            containerColor = CleanPureWhite,
                            labelColor = TextBlack
                        )
                    )
                }
            }
        }

        // Question List Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "TU Board Past Questions (${filteredQuestions.size})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextBlack
                )

                if (isEmergencyActive) {
                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = HighlightRedLight
                    ) {
                        Text(
                            text = "⚡ 24H High-Frequency",
                            color = HighlightRedDark,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }

        // Questions List
        items(filteredQuestions) { q ->
            TUQuestionCardItem(
                question = q,
                onPracticeClick = {
                    if (q.questionType == QuestionType.MCQ) {
                        viewModel.startMcqExam(q.subject)
                    } else {
                        viewModel.openSubjectiveExam(q.id)
                    }
                }
            )
        }
    }
}

@Composable
fun TUQuestionCardItem(
    question: TUQuestion,
    onPracticeClick: () -> Unit
) {
    val subjectBadgeColor = when (question.subject) {
        Subject.RURAL_DEVELOPMENT -> HighlightGreen
        Subject.SOCIOLOGY -> HighlightPurple
        Subject.COMPULSORY_LANGUAGE -> HighlightAmber
        Subject.INTERDISCIPLINARY -> HighlightBlue
    }

    val typeColor = when (question.questionType) {
        QuestionType.MCQ -> HighlightBlue
        QuestionType.SHORT_ANSWER -> HighlightGreen
        QuestionType.LONG_ANSWER -> HighlightRed
        QuestionType.CRITICAL_EVALUATION -> HighlightPurple
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPracticeClick() }
            .testTag("question_item_${question.id}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Badges Row
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
                        shape = RoundedCornerShape(4.dp),
                        color = CleanSurfaceVariant
                    ) {
                        Text(
                            text = question.courseCode,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(4.dp),
                        color = HighlightBlueLight
                    ) {
                        Text(
                            text = question.tuYearAsked,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    if (question.isHighFrequency) {
                        Surface(
                            shape = RoundedCornerShape(4.dp),
                            color = HighlightRedLight
                        ) {
                            Text(
                                text = "Repeated ★",
                                fontSize = 9.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = HighlightRedDark,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = CleanSurfaceVariant
                ) {
                    Text(
                        text = "${question.marks} Marks",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Question Text (English)
            Text(
                text = question.questionText,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.Bold,
                color = TextBlack
            )

            // Nepali Question Text
            question.nepaliQuestionText?.let { nepaliQ ->
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = nepaliQ,
                    fontSize = 12.sp,
                    color = HighlightGreenDark,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Footer Action
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = question.questionType.label,
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = typeColor
                )

                Text(
                    text = if (question.questionType == QuestionType.MCQ) "Solve MCQ →" else "Write & Grade Answer →",
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = HighlightBlue
                )
            }
        }
    }
}
