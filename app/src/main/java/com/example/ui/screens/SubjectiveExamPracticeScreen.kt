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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.data.model.Subject
import com.example.data.util.NepaliContentProvider
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
fun SubjectiveExamPracticeScreen(
    questionId: String,
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val question = viewModel.getQuestionById(questionId) ?: return
    val draftAnswer by viewModel.subjectiveDraftAnswer.collectAsState()
    val showModelAnswer by viewModel.showModelAnswer.collectAsState()
    val rubricScores by viewModel.rubricScores.collectAsState()
    val isSaved by viewModel.subjectiveSavedResult.collectAsState()
    val isGlobalNepali by viewModel.isNepaliLanguageActive.collectAsState()

    var showNepaliModelAnswer by remember { mutableStateOf(isGlobalNepali) }

    val totalAwardedMarks = rubricScores.values.sum()
    val totalMaxMarks = question.marks.toDouble()
    val percentage = if (totalMaxMarks > 0) (totalAwardedMarks / totalMaxMarks) * 100 else 0.0

    val divisionText = when {
        percentage >= 75.0 -> "First Division with Distinction 🏆"
        percentage >= 60.0 -> "First Division (TU 1st Class) 🌟"
        percentage >= 45.0 -> "Second Division (TU 2nd Class) 👍"
        percentage >= 40.0 -> "Third Division (Pass)"
        else -> "Needs Revision"
    }

    val nepaliQText = NepaliContentProvider.getNepaliQuestionText(question)
    val nepaliAns = NepaliContentProvider.getNepaliModelAnswer(question)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "TU Board ${question.questionType.label}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("back_button_subjective")
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
                .testTag("subjective_practice_scroll"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Question Header Card (Dual Language: English + Nepali)
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
                                shape = RoundedCornerShape(4.dp),
                                color = HighlightBlueLight
                            ) {
                                Text(
                                    text = "${question.courseCode} • ${question.subject.displayName}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightBlueDark,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }

                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = HighlightRedLight
                            ) {
                                Text(
                                    text = "${question.marks} Full Marks • ${question.tuYearAsked}",
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightRedDark,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "🇬🇧 ${question.questionText}",
                            fontSize = 14.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "🇳🇵 $nepaliQText",
                            fontSize = 13.sp,
                            color = HighlightGreenDark,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // 3. 📝 "How to Score 70%+ in TU Exam" Answer Formatter
            item {
                TuExamAnswerFormatterCard(isExpandedDefault = false)
            }

            // Draft Answer Input Field
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "Write / Outline Your Exam Answer (English or नेपाली)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Text(
                            text = "Practice structuring your introduction, sub-points, Nepal case study, and conclusion.",
                            fontSize = 11.sp,
                            color = TextDarkGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = draftAnswer,
                            onValueChange = { viewModel.updateDraftAnswer(it) },
                            placeholder = {
                                Text(
                                    text = "१. परिभाषा र पृष्ठभूमि (Introduction & Concept):\n२. मुख्य बुँदाहरू (Core Points & Analysis):\n३. नेपालको सन्दर्भ (Nepal Case Reference):\n४. निष्कर्ष र सुझाव (Conclusion):",
                                    fontSize = 12.sp,
                                    color = TextMutedGray
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .testTag("draft_answer_input"),
                            shape = RoundedCornerShape(8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = CleanPureWhite,
                                unfocusedContainerColor = CleanPureWhite,
                                focusedBorderColor = HighlightBlue,
                                unfocusedBorderColor = CleanBorder
                            )
                        )
                    }
                }
            }

            // Toggle Model Answer Button
            item {
                Button(
                    onClick = { viewModel.toggleModelAnswer() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (showModelAnswer) HighlightGreen else HighlightBlue
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = if (showModelAnswer) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (showModelAnswer) "Hide TU Model Answer" else "Reveal TU Model Answer (English & नेपाली)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.5.sp
                    )
                }
            }

            // Model Answer Display (Bilingual)
            if (showModelAnswer) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                        border = androidx.compose.foundation.BorderStroke(1.dp, HighlightGreen)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "📖 TU Board Model Answer",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightGreenDark
                                )

                                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = if (!showNepaliModelAnswer) HighlightBlue else CleanSurfaceVariant,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .clickable { showNepaliModelAnswer = false }
                                    ) {
                                        Text(
                                            text = "ENG",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (!showNepaliModelAnswer) Color.White else TextBlack,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }

                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = if (showNepaliModelAnswer) HighlightGreenDark else CleanSurfaceVariant,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .clickable { showNepaliModelAnswer = true }
                                    ) {
                                        Text(
                                            text = "नेपाली",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (showNepaliModelAnswer) Color.White else TextBlack,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = if (showNepaliModelAnswer) nepaliAns else question.modelAnswer,
                                fontSize = 12.5.sp,
                                color = TextBlack,
                                lineHeight = 17.sp
                            )
                        }
                    }
                }
            }

            // Self-Grading Rubric
            if (question.evaluationRubric.isNotEmpty()) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                        border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "TU Examiner Self-Scoring Rubric",
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextBlack
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            question.evaluationRubric.forEach { rubric ->
                                val currentScore = rubricScores[rubric.id] ?: 0.0

                                Column(modifier = Modifier.padding(vertical = 4.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(text = rubric.criterion, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = TextBlack)
                                        Text(text = "${currentScore.toInt()} / ${rubric.maxMarks.toInt()} M", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = HighlightBlueDark)
                                    }

                                    Slider(
                                        value = currentScore.toFloat(),
                                        onValueChange = { viewModel.setRubricScore(rubric.id, it.toDouble()) },
                                        valueRange = 0f..rubric.maxMarks.toFloat(),
                                        steps = (rubric.maxMarks - 1).toInt().coerceAtLeast(0),
                                        colors = SliderDefaults.colors(
                                            thumbColor = HighlightBlue,
                                            activeTrackColor = HighlightBlue
                                        )
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            // Score summary
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(text = "Total: ${totalAwardedMarks.toInt()} / ${totalMaxMarks.toInt()} Marks (${percentage.toInt()}%)", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = TextBlack)
                                    Text(text = divisionText, fontSize = 11.sp, color = HighlightGreenDark, fontWeight = FontWeight.SemiBold)
                                }

                                Button(
                                    onClick = { viewModel.saveSubjectiveGrade(question) },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue)
                                ) {
                                    Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(15.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Save Grade", fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                                }
                            }

                            if (isSaved) {
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = "✓ Result logged to Exam Readiness Dashboard", fontSize = 11.sp, color = HighlightGreenDark)
                            }
                        }
                    }
                }
            }
        }
    }
}
