package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.BilingualGlossaryItem
import com.example.ui.theme.CleanBorder
import com.example.ui.theme.CleanPureWhite
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

/**
 * 3. 📝 "How to Score 70%+ in TU Exam" 4-Box Answer Structure Visual Component
 */
@Composable
fun TuExamAnswerFormatterCard(
    modifier: Modifier = Modifier,
    isExpandedDefault: Boolean = true
) {
    var expanded by remember { mutableStateOf(isExpandedDefault) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("tu_answer_formatter_card"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.6f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = HighlightBlueLight,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = HighlightBlue,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "TU 70%+ Answer Blueprint",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Text(
                            text = "4-Box Universal Scoring Structure (Group B & C)",
                            fontSize = 11.sp,
                            color = TextDarkGray
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = HighlightBlueLight
                ) {
                    Text(
                        text = if (expanded) "Hide" else "View Blueprint",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = HighlightBlueDark,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    // Box 1: Blue - Concept & Theorist
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(HighlightBlueLight)
                            .border(1.dp, HighlightBlue.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = HighlightBlue,
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("1", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "🟦 20% | Conceptual Definition & Academic Thinker",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightBlueDark
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Define core terms precisely in 1-2 paragraphs. Quote foundational thinkers (e.g. Durkheim, Weber, Rostow, Amartya Sen) with exact year/publication reference.",
                                fontSize = 11.sp,
                                color = TextDarkGray,
                                lineHeight = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Box 2: Green - Core Arguments & Points
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(HighlightGreenLight)
                            .border(1.dp, HighlightGreen.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = HighlightGreen,
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("2", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "🟩 50% | Core Analytical Arguments (Subheadings)",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightGreenDark
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Present at least 4-6 categorized points with bold underlines. Include 1 comparative table or flowchart diagram to capture TU examiner visual interest.",
                                fontSize = 11.sp,
                                color = TextDarkGray,
                                lineHeight = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Box 3: Red - Nepal Context & Legal Acts
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(HighlightRedLight)
                            .border(1.dp, HighlightRed.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = HighlightRed,
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("3", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "🟥 20% | Contemporary Nepal Context & Constitutional Acts",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightRedDark
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Ground theoretical points in Nepalese reality. Cite Constitution Articles, Periodic Plan targets, Palika governance, or specific field studies (e.g. Chepang, Tharu, Melamchi).",
                                fontSize = 11.sp,
                                color = TextDarkGray,
                                lineHeight = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Box 4: Purple - Critical Synthesis & Conclusion
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(HighlightPurpleLight)
                            .border(1.dp, HighlightPurple.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = CircleShape,
                                    color = HighlightPurple,
                                    modifier = Modifier.size(18.dp)
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text("4", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "🟪 10% | Critical Synthesis & Policy Recommendations",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightPurpleDark
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "End with forward-looking constructive suggestions for policymakers and local Palikas. Avoid abrupt endings without synthesis.",
                                fontSize = 11.sp,
                                color = TextDarkGray,
                                lineHeight = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Full Dialog for 70%+ Exam Guide
 */
@Composable
fun AnswerStructureGuideModal(
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CleanPureWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = HighlightBlue,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "TU Board Scoring Blueprint (70%+)",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = TextDarkGray)
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = CleanBorder)

                LazyColumn(modifier = Modifier.weight(1f)) {
                    item {
                        TuExamAnswerFormatterCard(isExpandedDefault = true)
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = HighlightAmberLight),
                            border = androidx.compose.foundation.BorderStroke(1.dp, HighlightAmber.copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = "💡 Examiner's Marking Insights",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = HighlightAmber
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "• Group A (10×1 = 10 Marks): Direct objective accuracy. No negative marks.\n• Group B (6×5 = 30 Marks or 4×10 = 40 Marks): Expect 2.5 handwritten pages per answer with definitions and point-wise arguments.\n• Group C (Long 15/20 Marks): Expect 5-6 pages with conceptual framework, Nepal constitutional reference, and critical evaluation.",
                                    fontSize = 11.5.sp,
                                    color = TextDarkGray,
                                    lineHeight = 16.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Got It, Close", fontWeight = FontWeight.Bold, color = HighlightBlue)
                }
            }
        }
    }
}

/**
 * 2. 🇳🇵 Bilingual Glossary Modal (English ⇄ Nepali Devanagari)
 */
@Composable
fun BilingualGlossaryModal(
    viewModel: StudyViewModel,
    onDismiss: () -> Unit
) {
    val glossary = viewModel.getBilingualGlossary()
    var searchInput by remember { mutableStateOf("") }

    val filteredGlossary = remember(searchInput, glossary) {
        if (searchInput.isBlank()) glossary
        else glossary.filter {
            it.englishTerm.contains(searchInput, ignoreCase = true) ||
                    it.nepaliTerm.contains(searchInput, ignoreCase = true) ||
                    it.definitionEnglish.contains(searchInput, ignoreCase = true) ||
                    it.courseCode.contains(searchInput, ignoreCase = true)
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = CleanPureWhite)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightBlueLight,
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.GTranslate,
                                    contentDescription = null,
                                    tint = HighlightBlue,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Bilingual Terminology Glossary",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextBlack
                            )
                            Text(
                                text = "English ⇄ नेपाली (Devanagari) Concepts",
                                fontSize = 11.sp,
                                color = TextDarkGray
                            )
                        }
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close", tint = TextDarkGray)
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = searchInput,
                    onValueChange = { searchInput = it },
                    placeholder = { Text("Search term in English or नेपाली...", fontSize = 12.sp) },
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = HighlightBlue) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredGlossary) { item ->
                        BilingualGlossaryCard(item = item)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Close Glossary", fontWeight = FontWeight.Bold, color = HighlightBlue)
                }
            }
        }
    }
}

@Composable
fun BilingualGlossaryCard(item: BilingualGlossaryItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.englishTerm,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = HighlightBlueDark
                )
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = HighlightPurpleLight
                ) {
                    Text(
                        text = item.courseCode,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = HighlightPurpleDark,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = item.nepaliTerm,
                fontSize = 12.5.sp,
                fontWeight = FontWeight.Bold,
                color = HighlightGreenDark
            )

            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "EN: ${item.definitionEnglish}",
                fontSize = 11.sp,
                color = TextBlack,
                lineHeight = 14.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "नेपाली: ${item.definitionNepali}",
                fontSize = 11.sp,
                color = TextDarkGray,
                lineHeight = 14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = HighlightAmberLight
            ) {
                Text(
                    text = "Exam Context: ${item.examExample}",
                    fontSize = 10.sp,
                    color = TextBlack,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                )
            }
        }
    }
}
