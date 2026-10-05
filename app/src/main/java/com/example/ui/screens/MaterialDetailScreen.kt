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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.FileDownloadDone
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FileDownload
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

enum class NoteReaderLanguage {
    ENGLISH,
    NEPALI,
    DUAL_BILINGUAL
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialDetailScreen(
    materialId: String,
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val material = viewModel.getMaterialById(materialId) ?: return
    val isBookmarked = viewModel.isMaterialBookmarked(materialId)
    val isDownloaded = viewModel.isDownloaded(materialId)
    val fontSize by viewModel.readerFontSize.collectAsState()
    val isGlobalNepali by viewModel.isNepaliLanguageActive.collectAsState()

    var readerLanguage by remember {
        mutableStateOf(if (isGlobalNepali) NoteReaderLanguage.NEPALI else NoteReaderLanguage.DUAL_BILINGUAL)
    }

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

    val nepaliFullContent = NepaliContentProvider.getNepaliFullContent(material)
    val nepaliSummary = NepaliContentProvider.getNepaliSummary(material)
    val nepaliTakeaways = NepaliContentProvider.getNepaliTakeaways(material)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = subjectBgLight
                        ) {
                            Text(
                                text = material.courseCode,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = subjectBadgeColor,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (readerLanguage == NoteReaderLanguage.NEPALI) "वर्ष ${material.academicYear} नोट" else "Year ${material.academicYear} Note",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("back_button_material_detail")
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = TextBlack)
                    }
                },
                actions = {
                    // 7. Offline Download Toggle
                    IconButton(
                        onClick = { viewModel.toggleDownload(materialId) },
                        modifier = Modifier.testTag("action_download_detail")
                    ) {
                        Icon(
                            imageVector = if (isDownloaded) Icons.Default.FileDownloadDone else Icons.Outlined.FileDownload,
                            contentDescription = "Save Offline",
                            tint = if (isDownloaded) HighlightGreen else TextDarkGray
                        )
                    }

                    // Font Size Adjuster
                    IconButton(
                        onClick = {
                            val nextSize = if (fontSize >= 22) 14 else fontSize + 2
                            viewModel.setReaderFontSize(nextSize)
                        },
                        modifier = Modifier.testTag("action_font_size")
                    ) {
                        Icon(imageVector = Icons.Default.FormatSize, contentDescription = "Font Size", tint = TextDarkGray)
                    }

                    // 5. Bookmark Toggle
                    IconButton(
                        onClick = { viewModel.toggleBookmark(materialId) },
                        modifier = Modifier.testTag("action_bookmark_detail")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) HighlightAmber else TextDarkGray
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
                .testTag("material_detail_scroll"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header Card with Title & Nepali Subtitle
            item {
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
                            Text(
                                text = material.type.label,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = subjectBadgeColor
                            )

                            Text(
                                text = "⏱️ ${material.estimatedReadMinutes} min read",
                                fontSize = 11.sp,
                                color = TextDarkGray
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = material.title,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextBlack
                        )

                        // 2. 🇳🇵 Bilingual Nepali Subtitle
                        material.nepaliSubtitle?.let { subtitle ->
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = subtitle,
                                fontSize = 13.sp,
                                color = HighlightGreenDark,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Reference: ${material.authorOrSource} • ${material.yearOrReference}",
                            fontSize = 10.5.sp,
                            color = TextMutedGray
                        )
                    }
                }
            }

            // ======================== BILINGUAL LANGUAGE SELECTOR BAR ========================
            item {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = CleanSurfaceVariant,
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // Option 1: English
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (readerLanguage == NoteReaderLanguage.ENGLISH) HighlightBlue else Color.Transparent,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { readerLanguage = NoteReaderLanguage.ENGLISH }
                        ) {
                            Text(
                                text = "🇬🇧 English",
                                fontSize = 11.sp,
                                fontWeight = if (readerLanguage == NoteReaderLanguage.ENGLISH) FontWeight.Bold else FontWeight.Medium,
                                color = if (readerLanguage == NoteReaderLanguage.ENGLISH) Color.White else TextBlack,
                                modifier = Modifier
                                    .padding(vertical = 6.dp)
                                    .align(Alignment.CenterVertically),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }

                        // Option 2: Nepali
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (readerLanguage == NoteReaderLanguage.NEPALI) HighlightGreenDark else Color.Transparent,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { readerLanguage = NoteReaderLanguage.NEPALI }
                        ) {
                            Text(
                                text = "🇳🇵 नेपाली (Devanagari)",
                                fontSize = 11.sp,
                                fontWeight = if (readerLanguage == NoteReaderLanguage.NEPALI) FontWeight.Bold else FontWeight.Medium,
                                color = if (readerLanguage == NoteReaderLanguage.NEPALI) Color.White else TextBlack,
                                modifier = Modifier
                                    .padding(vertical = 6.dp)
                                    .align(Alignment.CenterVertically),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }

                        // Option 3: Dual
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = if (readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) HighlightPurpleDark else Color.Transparent,
                            modifier = Modifier
                                .weight(1.1f)
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { readerLanguage = NoteReaderLanguage.DUAL_BILINGUAL }
                        ) {
                            Text(
                                text = "📖 Dual Bilingual",
                                fontSize = 11.sp,
                                fontWeight = if (readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) FontWeight.Bold else FontWeight.Medium,
                                color = if (readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) Color.White else TextBlack,
                                modifier = Modifier
                                    .padding(vertical = 6.dp)
                                    .align(Alignment.CenterVertically),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                        }
                    }
                }
            }

            // Summary Card (English / Nepali / Dual)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = HighlightBlueLight.copy(alpha = 0.4f)),
                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = if (readerLanguage == NoteReaderLanguage.NEPALI) "📋 सारांश (Executive Summary)" else "📋 Executive Summary",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightBlueDark
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        if (readerLanguage == NoteReaderLanguage.NEPALI || readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) {
                            Text(
                                text = "🇳🇵 $nepaliSummary",
                                fontSize = (fontSize - 1).sp,
                                color = TextBlack,
                                lineHeight = (fontSize * 1.4).sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        if (readerLanguage == NoteReaderLanguage.ENGLISH || readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) {
                            if (readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "🇬🇧 ${material.summary}",
                                fontSize = (fontSize - 1).sp,
                                color = TextDarkGray,
                                lineHeight = (fontSize * 1.4).sp
                            )
                        }
                    }
                }
            }

            // 3. 📝 "70%+ Scoring Blueprint" Universal Answer Formatter
            item {
                TuExamAnswerFormatterCard(isExpandedDefault = false)
            }

            // Nepal Case Study Focus (Red/Green Highlight Box)
            material.nepalCaseStudyFocus?.let { caseStudy ->
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
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = HighlightRed,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "🇳🇵 Nepal Case Study & Constitutional Act Reference",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightRedDark
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = caseStudy,
                                    fontSize = 11.5.sp,
                                    color = TextBlack,
                                    lineHeight = 15.sp
                                )
                            }
                        }
                    }
                }
            }

            // Full Article Note Content (English / Nepali / Dual)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = when (readerLanguage) {
                                    NoteReaderLanguage.NEPALI -> "नेपाली प्राज्ञिक व्याख्या तथा नोट"
                                    NoteReaderLanguage.ENGLISH -> "English Lecture Notes & Analysis"
                                    NoteReaderLanguage.DUAL_BILINGUAL -> "Complete Dual Bilingual Lecture"
                                },
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = HighlightBlueDark
                            )

                            Surface(
                                shape = RoundedCornerShape(4.dp),
                                color = HighlightBlueLight
                            ) {
                                Text(
                                    text = "Font: ${fontSize}sp",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = HighlightBlueDark,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        when (readerLanguage) {
                            NoteReaderLanguage.NEPALI -> {
                                Text(
                                    text = nepaliFullContent,
                                    fontSize = fontSize.sp,
                                    color = TextBlack,
                                    lineHeight = (fontSize * 1.55).sp
                                )
                            }
                            NoteReaderLanguage.ENGLISH -> {
                                Text(
                                    text = material.fullContent,
                                    fontSize = fontSize.sp,
                                    color = TextBlack,
                                    lineHeight = (fontSize * 1.5).sp
                                )
                            }
                            NoteReaderLanguage.DUAL_BILINGUAL -> {
                                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                                    // Nepali Section
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(CleanSurfaceVariant.copy(alpha = 0.5f))
                                            .padding(12.dp)
                                    ) {
                                        Column {
                                            Text(
                                                text = "🇳🇵 नेपाली व्याख्या (Nepali Medium):",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = HighlightGreenDark
                                            )
                                            Spacer(modifier = Modifier.height(6.dp))
                                            Text(
                                                text = nepaliFullContent,
                                                fontSize = fontSize.sp,
                                                color = TextBlack,
                                                lineHeight = (fontSize * 1.55).sp
                                            )
                                        }
                                    }

                                    // English Section
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(HighlightBlueLight.copy(alpha = 0.3f))
                                            .padding(12.dp)
                                    ) {
                                        Column {
                                            Text(
                                                text = "🇬🇧 English Academic Transcript:",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = HighlightBlueDark
                                            )
                                            Spacer(modifier = Modifier.height(6.dp))
                                            Text(
                                                text = material.fullContent,
                                                fontSize = fontSize.sp,
                                                color = TextBlack,
                                                lineHeight = (fontSize * 1.5).sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Key Exam Takeaways (Green Box - Bilingual)
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = HighlightGreenLight),
                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightGreen.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = if (readerLanguage == NoteReaderLanguage.NEPALI) "✅ त्रि.वि. बोर्ड परीक्षाका मुख्य बुँदाहरू" else "✅ Key Takeaways for TU Board Exam",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = HighlightGreenDark
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        if (readerLanguage == NoteReaderLanguage.NEPALI || readerLanguage == NoteReaderLanguage.DUAL_BILINGUAL) {
                            nepaliTakeaways.forEach { takeaway ->
                                Text(
                                    text = "• $takeaway",
                                    fontSize = 11.5.sp,
                                    color = TextBlack,
                                    lineHeight = 16.sp,
                                    modifier = Modifier.padding(vertical = 2.dp)
                                )
                            }
                        }

                        if (readerLanguage == NoteReaderLanguage.ENGLISH) {
                            material.keyTakeaways.forEach { takeaway ->
                                Text(
                                    text = "• $takeaway",
                                    fontSize = 11.5.sp,
                                    color = TextBlack,
                                    lineHeight = 16.sp,
                                    modifier = Modifier.padding(vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Exam Keywords (Blue Highlight Pills)
            if (material.examKeywords.isNotEmpty()) {
                item {
                    Column {
                        Text(
                            text = if (readerLanguage == NoteReaderLanguage.NEPALI) "परीक्षाका मुख्य शब्दावलीहरू (EXAM KEYWORDS)" else "EXAM KEYWORDS & CONCEPTS",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextMutedGray,
                            letterSpacing = 0.5.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            material.examKeywords.forEach { keyword ->
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = HighlightBlueLight,
                                    border = androidx.compose.foundation.BorderStroke(1.dp, HighlightBlue.copy(alpha = 0.3f))
                                ) {
                                    Text(
                                        text = keyword,
                                        fontSize = 10.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = HighlightBlueDark,
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
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
