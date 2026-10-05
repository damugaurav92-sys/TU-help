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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Replay
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
fun ExamSessionScreen(
    subject: Subject?,
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val allQuestions = if (subject == null) {
        viewModel.getAllQuestions().filter { it.questionType == com.example.data.model.QuestionType.MCQ }
    } else {
        viewModel.getAllQuestions().filter { it.subject == subject && it.questionType == com.example.data.model.QuestionType.MCQ }
    }

    val currentIndex by viewModel.mcqCurrentIndex.collectAsState()
    val userAnswers by viewModel.mcqAnswers.collectAsState()
    val isSubmitted by viewModel.mcqSubmitted.collectAsState()

    val subjectLabel = subject?.displayName ?: "All BA Subjects"

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (isSubmitted) "Speed Test Result" else "TU Speed MCQ Exam",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("back_button_exam_session")
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextBlack)
                    }
                },
                actions = {
                    if (isSubmitted) {
                        IconButton(
                            onClick = { viewModel.resetMcqExam(subject) },
                            modifier = Modifier.testTag("retry_exam_action")
                        ) {
                            Icon(imageVector = Icons.Default.Replay, contentDescription = "Retry", tint = HighlightBlue)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CleanPureWhite)
            )
        }
    ) { innerPadding ->
        if (allQuestions.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CleanPureWhite)
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No MCQ questions available for this filter.",
                    fontSize = 14.sp,
                    color = TextDarkGray
                )
            }
            return@Scaffold
        }

        if (isSubmitted) {
            // Exam Result Summary Screen
            var correctCount = 0
            var totalMarks = 0.0
            var scoredMarks = 0.0

            allQuestions.forEach { q ->
                totalMarks += q.marks
                val ans = userAnswers[q.id]
                if (ans != null && ans == q.correctOptionIndex) {
                    correctCount++
                    scoredMarks += q.marks
                }
            }

            val percentage = if (totalMarks > 0) (scoredMarks / totalMarks) * 100 else 0.0
            val division = when {
                percentage >= 75.0 -> "Distinction"
                percentage >= 60.0 -> "First Division"
                percentage >= 45.0 -> "Second Division"
                percentage >= 40.0 -> "Third Division"
                else -> "Needs Revision"
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CleanPureWhite)
                    .padding(innerPadding)
                    .testTag("exam_results_scroll"),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("score_summary_card"),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                        border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.5f))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = if (percentage >= 40) HighlightGreenLight else HighlightRedLight,
                                modifier = Modifier.size(56.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.EmojiEvents,
                                        contentDescription = null,
                                        tint = if (percentage >= 40) HighlightGreenDark else HighlightRedDark,
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "TU Evaluation: $division",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = TextBlack
                            )

                            Text(
                                text = "$subjectLabel Speed Test",
                                fontSize = 12.sp,
                                color = TextDarkGray
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "${scoredMarks.toInt()} / ${totalMarks.toInt()}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (percentage >= 40) HighlightGreenDark else HighlightRedDark
                                    )
                                    Text("Score", fontSize = 11.sp, color = TextDarkGray)
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "${percentage.toInt()}%",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = HighlightBlueDark
                                    )
                                    Text("Accuracy", fontSize = 11.sp, color = TextDarkGray)
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "$correctCount / ${allQuestions.size}",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = HighlightGreenDark
                                    )
                                    Text("Correct", fontSize = 11.sp, color = TextDarkGray)
                                }
                            }
                        }
                    }
                }

                item {
                    Text(
                        text = "Question-by-Question Detailed Review",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                }

                itemsIndexed(allQuestions) { index, q ->
                    val userAns = userAnswers[q.id]
                    val isCorrect = userAns != null && userAns == q.correctOptionIndex

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isCorrect) HighlightGreenLight.copy(alpha = 0.3f) else HighlightRedLight.copy(alpha = 0.3f)
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp,
                            if (isCorrect) HighlightGreen else HighlightRed
                        )
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Q${index + 1} • ${q.courseCode}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isCorrect) HighlightGreenDark else HighlightRedDark
                                )

                                Surface(
                                    shape = RoundedCornerShape(4.dp),
                                    color = if (isCorrect) HighlightGreenLight else HighlightRedLight
                                ) {
                                    Text(
                                        text = if (isCorrect) "✓ Correct (+${q.marks})" else "✗ Incorrect (0)",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isCorrect) HighlightGreenDark else HighlightRedDark,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = q.questionText,
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextBlack
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            q.options?.forEachIndexed { optIndex, optText ->
                                val isChosen = userAns == optIndex
                                val isAnswer = q.correctOptionIndex == optIndex

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = if (isAnswer) Icons.Default.Check else if (isChosen) Icons.Default.Close else Icons.Default.Check,
                                        contentDescription = null,
                                        tint = if (isAnswer) HighlightGreenDark else if (isChosen) HighlightRedDark else Color.Transparent,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = "${'A' + optIndex}. $optText",
                                        fontSize = 12.sp,
                                        fontWeight = if (isAnswer || isChosen) FontWeight.Bold else FontWeight.Normal,
                                        color = if (isAnswer) HighlightGreenDark else if (isChosen) HighlightRedDark else TextDarkGray
                                    )
                                }
                            }

                            if (q.explanation.isNotBlank()) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "💡 Explanation: ${q.explanation}",
                                    fontSize = 11.sp,
                                    color = HighlightBlueDark,
                                    lineHeight = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        } else {
            // Live Exam Solving View
            val currentQ = allQuestions.getOrNull(currentIndex) ?: allQuestions.first()
            val selectedOption = userAnswers[currentQ.id]
            val progressFraction = (currentIndex.toFloat() + 1f) / allQuestions.size.toFloat()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(CleanPureWhite)
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Question ${currentIndex + 1} of ${allQuestions.size}",
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = HighlightBlueDark
                    )
                    Text(
                        text = "${userAnswers.size} / ${allQuestions.size} Answered",
                        fontSize = 11.5.sp,
                        color = TextDarkGray
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = { progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = HighlightGreen,
                    trackColor = CleanSurfaceVariant
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Question Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = HighlightBlueLight
                            ) {
                                Text(
                                    text = "${currentQ.subject.displayName} • ${currentQ.courseCode}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightBlueDark,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                            Text(
                                text = currentQ.tuYearAsked,
                                fontSize = 10.5.sp,
                                color = TextMutedGray
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = currentQ.questionText,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )

                        currentQ.nepaliQuestionText?.let { nepaliQ ->
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = nepaliQ,
                                fontSize = 12.5.sp,
                                color = HighlightGreenDark,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Options List
                currentQ.options?.forEachIndexed { optIndex, optText ->
                    val isSelected = selectedOption == optIndex
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .testTag("option_${optIndex}")
                            .clickable { viewModel.selectMcqOption(currentQ.id, optIndex) },
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) HighlightBlueLight else CleanPureWhite
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            if (isSelected) 2.dp else 1.dp,
                            if (isSelected) HighlightBlue else CleanBorder
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(CircleShape)
                                    .background(if (isSelected) HighlightBlue else CleanSurfaceVariant),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${'A' + optIndex}",
                                    color = if (isSelected) Color.White else TextBlack,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 11.5.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = optText,
                                fontSize = 13.sp,
                                color = TextBlack,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Bottom Navigation Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = { viewModel.prevMcqQuestion() },
                        enabled = currentIndex > 0,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.NavigateBefore, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Prev")
                    }

                    if (currentIndex == allQuestions.size - 1 || userAnswers.size == allQuestions.size) {
                        Button(
                            onClick = { viewModel.submitMcqExam(allQuestions, subjectLabel) },
                            colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.testTag("submit_exam_button")
                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Submit Exam", color = Color.White, fontWeight = FontWeight.Bold)
                        }
                    } else {
                        Button(
                            onClick = { viewModel.nextMcqQuestion(allQuestions.size) },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue)
                        ) {
                            Text("Next")
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(imageVector = Icons.Default.NavigateNext, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}
