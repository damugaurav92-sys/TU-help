package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
import com.example.ui.components.AnswerStructureGuideModal
import com.example.ui.components.BilingualGlossaryModal
import com.example.ui.theme.CleanBorder
import com.example.ui.theme.CleanPureWhite
import com.example.ui.theme.CleanSurfaceVariant
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
import com.example.ui.viewmodel.AppTab
import com.example.ui.viewmodel.StudyViewModel
import com.example.ui.viewmodel.SubScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScaffold(
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val selectedTab by viewModel.selectedTab.collectAsState()
    val subScreen by viewModel.subScreen.collectAsState()
    val isEmergencyMode by viewModel.isEmergencyModeActive.collectAsState()
    val languageMode by viewModel.appLanguageMode.collectAsState()
    val isNepaliMode by viewModel.isNepaliLanguageActive.collectAsState()
    val showAnswerDialog by viewModel.showAnswerStructureDialog.collectAsState()
    val showGlossaryDialog by viewModel.showGlossaryDialog.collectAsState()

    BackHandler(enabled = subScreen !is SubScreen.None) {
        viewModel.navigateBack()
    }

    if (showAnswerDialog) {
        AnswerStructureGuideModal(onDismiss = { viewModel.setAnswerStructureDialogVisible(false) })
    }

    if (showGlossaryDialog) {
        BilingualGlossaryModal(viewModel = viewModel, onDismiss = { viewModel.setGlossaryDialogVisible(false) })
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (subScreen is SubScreen.None) {
                Surface(
                    color = CleanPureWhite,
                    tonalElevation = 1.dp,
                    shadowElevation = 2.dp
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        TopAppBar(
                            title = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = HighlightBlue
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.School,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(15.dp)
                                            )
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text(
                                                text = "TU BA",
                                                color = Color.White,
                                                fontSize = 11.5.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = if (isNepaliMode) "त्रि.वि. स्नातक तह तयारी" else "TU BA Companion",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = TextBlack
                                        )
                                        Text(
                                            text = "Rural Development & Sociology",
                                            fontSize = 10.sp,
                                            color = TextDarkGray
                                        )
                                    }
                                }
                            },
                            actions = {
                                // 2. 🇳🇵 Bilingual Quick Switch (ENG ⇄ NEP ⇄ DUAL)
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = when (languageMode) {
                                        com.example.data.model.AppLanguageMode.ENGLISH -> HighlightBlueLight
                                        com.example.data.model.AppLanguageMode.NEPALI -> HighlightGreenLight
                                        com.example.data.model.AppLanguageMode.BILINGUAL -> HighlightPurpleLight
                                    },
                                    border = androidx.compose.foundation.BorderStroke(
                                        1.dp,
                                        when (languageMode) {
                                            com.example.data.model.AppLanguageMode.ENGLISH -> HighlightBlue
                                            com.example.data.model.AppLanguageMode.NEPALI -> HighlightGreen
                                            com.example.data.model.AppLanguageMode.BILINGUAL -> HighlightPurple
                                        }
                                    ),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable { viewModel.cycleLanguageMode() }
                                        .testTag("btn_toggle_nepali")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = when (languageMode) {
                                                com.example.data.model.AppLanguageMode.ENGLISH -> "🇬🇧 ENG"
                                                com.example.data.model.AppLanguageMode.NEPALI -> "🇳🇵 नेपाली"
                                                com.example.data.model.AppLanguageMode.BILINGUAL -> "🌐 दुवै"
                                            },
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = when (languageMode) {
                                                com.example.data.model.AppLanguageMode.ENGLISH -> HighlightBlueDark
                                                com.example.data.model.AppLanguageMode.NEPALI -> HighlightGreenDark
                                                com.example.data.model.AppLanguageMode.BILINGUAL -> HighlightPurpleDark
                                            }
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(6.dp))

                                // 1. ⚡ 24H Emergency High Yield Mode Button
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = if (isEmergencyMode) HighlightRed else HighlightRedLight,
                                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightRed.copy(alpha = 0.6f)),
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable { viewModel.toggleEmergencyMode() }
                                        .testTag("btn_toggle_emergency")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Bolt,
                                            contentDescription = "Emergency Mode",
                                            tint = if (isEmergencyMode) Color.White else HighlightRed,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            text = "24H",
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isEmergencyMode) Color.White else HighlightRedDark
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(4.dp))

                                // 3. 📝 70%+ Blueprint Guide Dialog Action
                                IconButton(
                                    onClick = { viewModel.setAnswerStructureDialogVisible(true) },
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Lightbulb,
                                        contentDescription = "70%+ Blueprint",
                                        tint = HighlightBlueDark,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                // 2. 📖 Bilingual Glossary Action
                                IconButton(
                                    onClick = { viewModel.setGlossaryDialogVisible(true) },
                                    modifier = Modifier.size(36.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.GTranslate,
                                        contentDescription = "Glossary",
                                        tint = HighlightGreen,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = CleanPureWhite
                            )
                        )

                        // ⚡ Emergency Banner when active
                        if (isEmergencyMode) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(HighlightRed)
                                    .padding(horizontal = 12.dp, vertical = 4.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            imageVector = Icons.Default.Bolt,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "⚡ 24H EMERGENCY SPRINT ACTIVE • Filtered to High-Yield Past Questions",
                                            color = Color.White,
                                            fontSize = 10.5.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Text(
                                        text = "Exit",
                                        color = Color.White,
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .clickable { viewModel.toggleEmergencyMode() }
                                            .padding(2.dp)
                                    )
                                }
                            }
                        }

                        HorizontalDivider(color = CleanBorder, thickness = 1.dp)
                    }
                }
            }
        },
        bottomBar = {
            if (subScreen is SubScreen.None) {
                Surface(
                    color = CleanPureWhite,
                    tonalElevation = 3.dp,
                    shadowElevation = 8.dp
                ) {
                    NavigationBar(
                        containerColor = CleanPureWhite,
                        tonalElevation = 0.dp
                    ) {
                        NavigationBarItem(
                            selected = selectedTab == AppTab.DAY_PLAN,
                            onClick = { viewModel.selectTab(AppTab.DAY_PLAN) },
                            icon = {
                                Icon(
                                    imageVector = if (selectedTab == AppTab.DAY_PLAN) Icons.Filled.DateRange else Icons.Outlined.DateRange,
                                    contentDescription = "16-Day Plan"
                                )
                            },
                            label = {
                                Text(
                                    text = if (isNepaliMode) "१६-दिने योजना" else "16-Day Plan",
                                    fontSize = 11.sp,
                                    fontWeight = if (selectedTab == AppTab.DAY_PLAN) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = HighlightBlue,
                                selectedTextColor = HighlightBlueDark,
                                unselectedIconColor = TextDarkGray,
                                unselectedTextColor = TextDarkGray,
                                indicatorColor = HighlightBlueLight
                            ),
                            modifier = Modifier.testTag("nav_day_plan")
                        )

                        NavigationBarItem(
                            selected = selectedTab == AppTab.MATERIALS,
                            onClick = { viewModel.selectTab(AppTab.MATERIALS) },
                            icon = {
                                Icon(
                                    imageVector = if (selectedTab == AppTab.MATERIALS) Icons.Filled.MenuBook else Icons.Outlined.MenuBook,
                                    contentDescription = "Materials"
                                )
                            },
                            label = {
                                Text(
                                    text = if (isNepaliMode) "अध्ययन सामग्री" else "Materials",
                                    fontSize = 11.sp,
                                    fontWeight = if (selectedTab == AppTab.MATERIALS) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = HighlightBlue,
                                selectedTextColor = HighlightBlueDark,
                                unselectedIconColor = TextDarkGray,
                                unselectedTextColor = TextDarkGray,
                                indicatorColor = HighlightBlueLight
                            ),
                            modifier = Modifier.testTag("nav_materials")
                        )

                        NavigationBarItem(
                            selected = selectedTab == AppTab.EXAM,
                            onClick = { viewModel.selectTab(AppTab.EXAM) },
                            icon = {
                                Icon(
                                    imageVector = if (selectedTab == AppTab.EXAM) Icons.Filled.Quiz else Icons.Outlined.Quiz,
                                    contentDescription = "TU Exam"
                                )
                            },
                            label = {
                                Text(
                                    text = if (isNepaliMode) "त्रि.वि. परीक्षा" else "TU Exam",
                                    fontSize = 11.sp,
                                    fontWeight = if (selectedTab == AppTab.EXAM) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = HighlightBlue,
                                selectedTextColor = HighlightBlueDark,
                                unselectedIconColor = TextDarkGray,
                                unselectedTextColor = TextDarkGray,
                                indicatorColor = HighlightBlueLight
                            ),
                            modifier = Modifier.testTag("nav_exam")
                        )

                        NavigationBarItem(
                            selected = selectedTab == AppTab.NOTES,
                            onClick = { viewModel.selectTab(AppTab.NOTES) },
                            icon = {
                                Icon(
                                    imageVector = if (selectedTab == AppTab.NOTES) Icons.Filled.Analytics else Icons.Outlined.Analytics,
                                    contentDescription = "Notes & Stats"
                                )
                            },
                            label = {
                                Text(
                                    text = if (isNepaliMode) "प्रगति र टिपोट" else "Notes & Stats",
                                    fontSize = 11.sp,
                                    fontWeight = if (selectedTab == AppTab.NOTES) FontWeight.Bold else FontWeight.Medium
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = HighlightBlue,
                                selectedTextColor = HighlightBlueDark,
                                unselectedIconColor = TextDarkGray,
                                unselectedTextColor = TextDarkGray,
                                indicatorColor = HighlightBlueLight
                            ),
                            modifier = Modifier.testTag("nav_notes")
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(CleanPureWhite)
                .padding(if (subScreen is SubScreen.None) innerPadding else androidx.compose.foundation.layout.PaddingValues())
        ) {
            AnimatedContent(
                targetState = subScreen,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "ScreenTransition"
            ) { targetSubScreen ->
                when (targetSubScreen) {
                    is SubScreen.None -> {
                        when (selectedTab) {
                            AppTab.DAY_PLAN -> DayPlanScreen(viewModel = viewModel)
                            AppTab.MATERIALS -> MaterialsHubScreen(viewModel = viewModel)
                            AppTab.EXAM -> ExamScreen(viewModel = viewModel)
                            AppTab.NOTES -> ProgressAndNotesScreen(viewModel = viewModel)
                        }
                    }
                    is SubScreen.DayDetail -> {
                        DayDetailScreen(dayNumber = targetSubScreen.dayNumber, viewModel = viewModel)
                    }
                    is SubScreen.MaterialDetail -> {
                        MaterialDetailScreen(materialId = targetSubScreen.materialId, viewModel = viewModel)
                    }
                    is SubScreen.McqSession -> {
                        ExamSessionScreen(subject = targetSubScreen.subject, viewModel = viewModel)
                    }
                    is SubScreen.SubjectiveSession -> {
                        SubjectiveExamPracticeScreen(questionId = targetSubScreen.questionId, viewModel = viewModel)
                    }
                    is SubScreen.YearSyllabusDetail -> {
                        YearSyllabusDetailScreen(initialYear = targetSubScreen.yearNumber, viewModel = viewModel)
                    }
                }
            }
        }
    }
}
