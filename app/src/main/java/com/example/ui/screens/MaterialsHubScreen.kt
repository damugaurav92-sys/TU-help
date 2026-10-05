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
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.FileDownloadDone
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FileDownload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.data.model.AppLanguageMode
import com.example.data.model.StudyMaterial
import com.example.data.model.Subject
import com.example.data.model.TUCoursePaper
import com.example.data.util.NepaliContentProvider
import com.example.ui.theme.CleanBorder
import com.example.ui.theme.CleanPureWhite
import com.example.ui.theme.CleanSurfaceVariant
import com.example.ui.theme.HighlightAmber
import com.example.ui.theme.HighlightAmberDark
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
fun MaterialsHubScreen(
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val filteredMaterials = viewModel.getFilteredMaterials()
    val selectedYear by viewModel.selectedYearFilter.collectAsState()
    val selectedCourseCode by viewModel.selectedCourseCodeFilter.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val filterOnlyBookmarked by viewModel.filterOnlyBookmarked.collectAsState()
    val languageMode by viewModel.appLanguageMode.collectAsState()
    val isEmergencyActive by viewModel.isEmergencyModeActive.collectAsState()

    val currentYear = selectedYear ?: 1
    val yearSyllabus = viewModel.getCurriculumByYear(currentYear)
    val yearPapers = viewModel.getPapersForYear(currentYear)
    val selectedPaper = yearPapers.find { it.courseCode.equals(selectedCourseCode, ignoreCase = true) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CleanPureWhite)
            .testTag("materials_hub_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // TOP: Language Mode Switcher & Global Actions
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "TU 4-Year B.A. Study Hub"
                                AppLanguageMode.NEPALI -> "त्रि.वि. ४ वर्षे स्नातक अध्ययन केन्द्र"
                                AppLanguageMode.BILINGUAL -> "TU Study Hub • द्विभाषिक अध्ययन"
                            },
                            fontSize = 19.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextBlack
                        )
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "Select Year → Select Subject → Read Full Notes"
                                AppLanguageMode.NEPALI -> "पहिले वर्ष छान्नुहोस् → ५ वटा विषय हेर्नुहोस् → सामग्री पढ्नुहोस्"
                                AppLanguageMode.BILINGUAL -> "1. Choose Year → 2. Choose Subject → 3. Read Study Material"
                            },
                            fontSize = 11.5.sp,
                            color = HighlightBlueDark,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    // Syllabus Quick Shortcut
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = HighlightBlueLight,
                        border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.4f)),
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { viewModel.openYearSyllabusDetail(currentYear) }
                            .testTag("btn_syllabus_shortcut")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = null,
                                tint = HighlightBlueDark,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = when (languageMode) {
                                    AppLanguageMode.ENGLISH -> "Syllabus"
                                    AppLanguageMode.NEPALI -> "पाठ्यक्रम"
                                    AppLanguageMode.BILINGUAL -> "Syllabus"
                                },
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = HighlightBlueDark
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Language Mode Selector Bar (ENG | NEP | DUAL)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CleanSurfaceVariant, RoundedCornerShape(10.dp))
                        .border(1.dp, CleanBorder, RoundedCornerShape(10.dp))
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val langOptions = listOf(
                        AppLanguageMode.ENGLISH to "🇬🇧 English",
                        AppLanguageMode.NEPALI to "🇳🇵 नेपाली",
                        AppLanguageMode.BILINGUAL to "🌐 Both / दुवै"
                    )

                    langOptions.forEach { (mode, label) ->
                        val isSelected = languageMode == mode
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (isSelected) HighlightBlue else Color.Transparent,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { viewModel.setLanguageMode(mode) }
                                .testTag("lang_toggle_${mode.name}")
                        ) {
                            Text(
                                text = label,
                                fontSize = 12.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color.White else TextBlack,
                                modifier = Modifier.padding(vertical = 7.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Search Input across materials
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { viewModel.setSearchQuery(it) },
                    placeholder = {
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "Search 20 papers (e.g. RD 421, Durkheim, Muluki Ain)..."
                                AppLanguageMode.NEPALI -> "सम्पूर्ण २० पत्र खोज्नुहोस् (जस्तै: RD 421, मार्क्स, मुलुकी ऐन)..."
                                AppLanguageMode.BILINGUAL -> "Search across all 20 papers / सामग्री खोज्नुहोस्..."
                            },
                            fontSize = 12.sp,
                            color = TextMutedGray
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = HighlightBlue
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { viewModel.setSearchQuery("") }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    tint = TextDarkGray
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("search_materials_input"),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = CleanPureWhite,
                        unfocusedContainerColor = CleanPureWhite,
                        focusedBorderColor = HighlightBlue,
                        unfocusedBorderColor = CleanBorder,
                        focusedTextColor = TextBlack,
                        unfocusedTextColor = TextBlack
                    ),
                    singleLine = true
                )
            }
        }

        // =========================================================================
        // STEP 1: CHOOSE ACADEMIC YEAR (1st, 2nd, 3rd, 4th Year)
        // =========================================================================
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CleanSurfaceVariant, RoundedCornerShape(12.dp))
                    .border(1.dp, HighlightBlue.copy(alpha = 0.25f), RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightBlue,
                            modifier = Modifier.size(20.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("1", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "STEP 1: CHOOSE ACADEMIC YEAR"
                                AppLanguageMode.NEPALI -> "चरण १: शैक्षिक वर्ष छान्नुहोस्"
                                AppLanguageMode.BILINGUAL -> "STEP 1: CHOOSE YEAR (वर्ष रोज्नुहोस्)"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark,
                            letterSpacing = 0.5.sp
                        )
                    }

                    Text(
                        text = "500 Marks / Year",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDarkGray
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 4-Year Segmented Option Tabs
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val yearTabs = listOf(
                        1 to ("1st Year" to "प्रथम वर्ष"),
                        2 to ("2nd Year" to "दोस्रो वर्ष"),
                        3 to ("3rd Year" to "तेस्रो वर्ष"),
                        4 to ("4th Year" to "चौथो वर्ष")
                    )

                    yearTabs.forEach { (yearVal, labels) ->
                        val isSelected = currentYear == yearVal
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) HighlightBlue else CleanPureWhite,
                            border = androidx.compose.foundation.BorderStroke(
                                if (isSelected) 1.5.dp else 1.dp,
                                if (isSelected) HighlightBlue else CleanBorder
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable {
                                    viewModel.setYearFilter(yearVal)
                                }
                                .testTag("tab_year_$yearVal")
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = if (languageMode == AppLanguageMode.NEPALI) labels.second else labels.first,
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSelected) Color.White else TextBlack
                                )
                                Text(
                                    text = if (languageMode == AppLanguageMode.NEPALI) "५ विषय" else "5 Papers",
                                    fontSize = 9.5.sp,
                                    color = if (isSelected) Color.White.copy(alpha = 0.9f) else TextDarkGray
                                )
                            }
                        }
                    }
                }
            }
        }

        // =========================================================================
        // STEP 2: SHOW ALL 5 SUBJECTS FOR THE CHOSEN YEAR
        // =========================================================================
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CleanPureWhite, RoundedCornerShape(12.dp))
                    .border(1.dp, HighlightGreen.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightGreen,
                            modifier = Modifier.size(20.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("2", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "STEP 2: ALL 5 SUBJECTS (YEAR $currentYear)"
                                AppLanguageMode.NEPALI -> "चरण २: वर्ष $currentYear का ५ वटै विषयहरू"
                                AppLanguageMode.BILINGUAL -> "STEP 2: ALL 5 SUBJECTS (५ वटा विषयहरू)"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightGreenDark,
                            letterSpacing = 0.5.sp
                        )
                    }

                    // "View All 5" toggle
                    Text(
                        text = if (selectedCourseCode == null) "✓ All 5 Selected" else "Show All 5",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (selectedCourseCode == null) HighlightGreenDark else HighlightBlue,
                        modifier = Modifier.clickable { viewModel.selectSubject(null) }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // The 5 Subject Cards for Selected Year
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    yearPapers.forEachIndexed { index, paper ->
                        val isSelected = selectedCourseCode?.equals(paper.courseCode, ignoreCase = true) == true
                        val badgeColor = when (paper.major) {
                            Subject.RURAL_DEVELOPMENT -> HighlightGreen
                            Subject.SOCIOLOGY -> HighlightPurple
                            Subject.COMPULSORY_LANGUAGE -> HighlightAmber
                            Subject.INTERDISCIPLINARY -> HighlightBlue
                        }
                        val badgeBg = when (paper.major) {
                            Subject.RURAL_DEVELOPMENT -> HighlightGreenLight
                            Subject.SOCIOLOGY -> HighlightPurpleLight
                            Subject.COMPULSORY_LANGUAGE -> HighlightAmberLight
                            Subject.INTERDISCIPLINARY -> HighlightBlueLight
                        }

                        val completedPercentage = viewModel.getUnitCompletionPercentage(paper.courseCode)

                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) badgeBg.copy(alpha = 0.6f) else CleanPureWhite,
                            border = androidx.compose.foundation.BorderStroke(
                                if (isSelected) 2.dp else 1.dp,
                                if (isSelected) badgeColor else CleanBorder
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .clickable {
                                    viewModel.selectSubject(if (isSelected) null else paper.courseCode)
                                }
                                .testTag("subject_card_${paper.courseCode}")
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = badgeBg,
                                        border = androidx.compose.foundation.BorderStroke(1.dp, badgeColor.copy(alpha = 0.4f))
                                    ) {
                                        Text(
                                            text = paper.courseCode,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.ExtraBold,
                                            color = badgeColor,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = when (languageMode) {
                                                AppLanguageMode.ENGLISH -> paper.title
                                                AppLanguageMode.NEPALI -> paper.nepaliTitle
                                                AppLanguageMode.BILINGUAL -> "${paper.title} / ${paper.nepaliTitle}"
                                            },
                                            fontSize = 12.sp,
                                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                                            color = TextBlack,
                                            maxLines = 2
                                        )
                                        Text(
                                            text = "${paper.category.label} • 100 Marks • Pass: 40",
                                            fontSize = 10.sp,
                                            color = TextDarkGray
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.width(6.dp))

                                Column(horizontalAlignment = Alignment.End) {
                                    Surface(
                                        shape = RoundedCornerShape(4.dp),
                                        color = if (completedPercentage > 0) HighlightGreenLight else CleanSurfaceVariant
                                    ) {
                                        Text(
                                            text = "$completedPercentage% Ready",
                                            fontSize = 9.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (completedPercentage > 0) HighlightGreenDark else TextMutedGray,
                                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                        )
                                    }
                                    if (isSelected) {
                                        Text(
                                            text = "Active ✓",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = badgeColor
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // =========================================================================
        // STEP 3: STUDY MATERIAL & UNITS FOR THE CHOSEN SUBJECT
        // =========================================================================
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightPurple,
                            modifier = Modifier.size(20.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("3", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = when (languageMode) {
                                AppLanguageMode.ENGLISH -> "STEP 3: STUDY MATERIALS & NOTES"
                                AppLanguageMode.NEPALI -> "चरण ३: अध्ययन सामग्री, नोट तथा एकाइहरू"
                                AppLanguageMode.BILINGUAL -> "STEP 3: STUDY MATERIALS (${if (selectedCourseCode != null) selectedCourseCode else "All 5 Subjects"})"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightPurpleDark,
                            letterSpacing = 0.5.sp
                        )
                    }

                    // Bookmarked filter chip
                    FilterChip(
                        selected = filterOnlyBookmarked,
                        onClick = { viewModel.toggleOnlyBookmarked() },
                        label = {
                            Text(
                                text = "⭐ Bookmarks",
                                fontSize = 10.5.sp,
                                fontWeight = if (filterOnlyBookmarked) FontWeight.Bold else FontWeight.Medium
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = HighlightAmber,
                            selectedLabelColor = Color.White,
                            containerColor = CleanPureWhite,
                            labelColor = TextBlack
                        ),
                        border = FilterChipDefaults.filterChipBorder(
                            borderColor = if (filterOnlyBookmarked) HighlightAmber else CleanBorder,
                            enabled = true,
                            selected = filterOnlyBookmarked
                        )
                    )
                }

                // If a single course paper is active, show its 5-Unit Checklist banner
                if (selectedPaper != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailedSubjectUnitChecklistCard(
                        paper = selectedPaper,
                        languageMode = languageMode,
                        viewModel = viewModel
                    )
                }
            }
        }

        // Count Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (languageMode) {
                        AppLanguageMode.ENGLISH -> "Showing ${filteredMaterials.size} Study Materials & Notes"
                        AppLanguageMode.NEPALI -> "${filteredMaterials.size} वटा पाठ्यसामग्री तथा नोटहरू उपलब्ध"
                        AppLanguageMode.BILINGUAL -> "Showing ${filteredMaterials.size} Materials (${if (selectedCourseCode != null) selectedCourseCode else "All Subjects"})"
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextBlack
                )

                if (selectedCourseCode != null || filterOnlyBookmarked) {
                    Text(
                        text = "Show All 5 Subjects",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = HighlightBlueDark,
                        modifier = Modifier.clickable {
                            viewModel.selectSubject(null)
                            if (filterOnlyBookmarked) viewModel.toggleOnlyBookmarked()
                        }
                    )
                }
            }
        }

        // Material List Cards
        items(filteredMaterials) { material ->
            val isBookmarked = viewModel.isMaterialBookmarked(material.id)
            val isDownloaded = viewModel.isDownloaded(material.id)

            BilingualStudyMaterialCard(
                material = material,
                languageMode = languageMode,
                isBookmarked = isBookmarked,
                isDownloaded = isDownloaded,
                onCardClick = { viewModel.openMaterial(material.id) },
                onToggleBookmark = { viewModel.toggleBookmark(material.id) },
                onToggleDownload = { viewModel.toggleDownload(material.id) }
            )
        }
    }
}

/**
 * 5-Unit Checklist card for the active subject paper
 */
@Composable
fun DetailedSubjectUnitChecklistCard(
    paper: TUCoursePaper,
    languageMode: AppLanguageMode,
    viewModel: StudyViewModel
) {
    val completedPercentage = viewModel.getUnitCompletionPercentage(paper.courseCode)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, HighlightBlue.copy(alpha = 0.4f))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "${paper.courseCode}: ${if (languageMode == AppLanguageMode.NEPALI) paper.nepaliTitle else paper.title}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextBlack
                    )
                    Text(
                        text = "5 Syllabus Units • Tap checkmark [✓] as you finish revising",
                        fontSize = 10.5.sp,
                        color = TextDarkGray
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = if (completedPercentage >= 60) HighlightGreenLight else HighlightAmberLight
                ) {
                    Text(
                        text = "$completedPercentage% Exam Ready",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (completedPercentage >= 60) HighlightGreenDark else HighlightAmberDark,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // 5 Units with interactive Checkboxes
            paper.units.forEachIndexed { idx, unitText ->
                val unitNum = idx + 1
                val isDone = viewModel.isUnitCompleted(paper.courseCode, unitNum)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                        .clickable { viewModel.toggleUnitCompletion(paper.courseCode, unitNum) }
                        .padding(vertical = 4.dp, horizontal = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isDone) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                        contentDescription = null,
                        tint = if (isDone) HighlightGreen else TextMutedGray,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = unitText,
                        fontSize = 11.sp,
                        fontWeight = if (isDone) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (isDone) TextBlack else TextDarkGray,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

/**
 * Full bilingual study material card with instant English/Nepali reading
 */
@Composable
fun BilingualStudyMaterialCard(
    material: StudyMaterial,
    languageMode: AppLanguageMode,
    isBookmarked: Boolean,
    isDownloaded: Boolean,
    onCardClick: () -> Unit,
    onToggleBookmark: () -> Unit,
    onToggleDownload: () -> Unit
) {
    var localLangOverride by remember { mutableStateOf<AppLanguageMode?>(null) }
    val effectiveMode = localLangOverride ?: languageMode

    val subjectBadgeColor = when (material.subject) {
        Subject.RURAL_DEVELOPMENT -> HighlightGreen
        Subject.SOCIOLOGY -> HighlightPurple
        Subject.COMPULSORY_LANGUAGE -> HighlightAmber
        Subject.INTERDISCIPLINARY -> HighlightBlue
    }

    val subjectBgLight = when (material.subject) {
        Subject.RURAL_DEVELOPMENT -> HighlightGreenLight
        Subject.SOCIOLOGY -> HighlightPurpleLight
        Subject.COMPULSORY_LANGUAGE -> HighlightAmberLight
        Subject.INTERDISCIPLINARY -> HighlightBlueLight
    }

    val nepaliSummary = NepaliContentProvider.getNepaliSummary(material)
    val nepaliTakeaways = NepaliContentProvider.getNepaliTakeaways(material)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() }
            .testTag("material_card_${material.id}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header: Code Badge + Material Type + Download & Bookmark
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
                        color = subjectBgLight,
                        border = androidx.compose.foundation.BorderStroke(1.dp, subjectBadgeColor.copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = "${material.courseCode} • Year ${material.academicYear}",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = subjectBadgeColor,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = CleanSurfaceVariant
                    ) {
                        Text(
                            text = if (effectiveMode == AppLanguageMode.NEPALI) material.type.nepaliLabel else material.type.label,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextDarkGray,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Download indicator
                    IconButton(
                        onClick = onToggleDownload,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = if (isDownloaded) Icons.Default.CloudDone else Icons.Outlined.FileDownload,
                            contentDescription = "Download Offline",
                            tint = if (isDownloaded) HighlightGreenDark else TextMutedGray,
                            modifier = Modifier.size(17.dp)
                        )
                    }

                    // Bookmark star
                    IconButton(
                        onClick = onToggleBookmark,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Star else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) HighlightAmber else TextMutedGray,
                            modifier = Modifier.size(17.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Title in selected language or bilingual
            Text(
                text = when (effectiveMode) {
                    AppLanguageMode.ENGLISH -> material.title
                    AppLanguageMode.NEPALI -> material.nepaliSubtitle ?: material.title
                    AppLanguageMode.BILINGUAL -> "${material.title}\n${material.nepaliSubtitle ?: ""}"
                },
                fontSize = 14.5.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextBlack,
                lineHeight = 19.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Summary Text
            Text(
                text = when (effectiveMode) {
                    AppLanguageMode.ENGLISH -> material.summary
                    AppLanguageMode.NEPALI -> nepaliSummary
                    AppLanguageMode.BILINGUAL -> "${material.summary}\n\n🇳🇵 $nepaliSummary"
                },
                fontSize = 12.sp,
                color = TextDarkGray,
                lineHeight = 17.sp,
                maxLines = 4
            )

            // Key Takeaways Highlight Box
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = CleanSurfaceVariant,
                border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = if (effectiveMode == AppLanguageMode.NEPALI) "📌 मुख्य परीक्षा बुँदाहरू (Takeaways):" else "📌 Key TU Takeaways:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    val takeawaysToShow = if (effectiveMode == AppLanguageMode.NEPALI) nepaliTakeaways else material.keyTakeaways
                    takeawaysToShow.take(2).forEach { point ->
                        Text(
                            text = "• $point",
                            fontSize = 11.sp,
                            color = TextDarkGray,
                            lineHeight = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Bottom Actions: Language quick switch + Open Note button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Card level inline language switcher
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = CleanPureWhite,
                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.4f)),
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .clickable {
                            localLangOverride = when (effectiveMode) {
                                AppLanguageMode.ENGLISH -> AppLanguageMode.NEPALI
                                AppLanguageMode.NEPALI -> AppLanguageMode.BILINGUAL
                                AppLanguageMode.BILINGUAL -> AppLanguageMode.ENGLISH
                            }
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.GTranslate,
                            contentDescription = null,
                            tint = HighlightBlueDark,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = when (effectiveMode) {
                                AppLanguageMode.ENGLISH -> "Switch to नेपाली"
                                AppLanguageMode.NEPALI -> "Switch to Dual / दुवै"
                                AppLanguageMode.BILINGUAL -> "Switch to English"
                            },
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark
                        )
                    }
                }

                // Read Note button
                Button(
                    onClick = onCardClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = HighlightBlue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 5.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text(
                        text = if (effectiveMode == AppLanguageMode.NEPALI) "नोट पढ्नुहोस् →" else "Read Full Note →",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
