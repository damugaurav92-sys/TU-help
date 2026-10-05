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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.GTranslate
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.data.database.UserNoteEntity
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
fun ProgressAndNotesScreen(
    viewModel: StudyViewModel,
    modifier: Modifier = Modifier
) {
    val progressList by viewModel.readingProgress.collectAsState()
    val bookmarks by viewModel.bookmarks.collectAsState()
    val notes by viewModel.userNotes.collectAsState()
    val attempts by viewModel.examAttempts.collectAsState()
    val completedUnits by viewModel.completedUnits.collectAsState()

    val showNoteDialog by viewModel.showNoteDialog.collectAsState()
    val editingNote by viewModel.editingNote.collectAsState()

    val completedDays = progressList.count { it.isCompleted }
    val totalMinutes = progressList.sumOf { it.minutesSpent }
    val totalHours = totalMinutes / 60
    val remMinutes = totalMinutes % 60

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CleanPureWhite)
            .testTag("progress_notes_screen"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Analytics Card
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
                                text = "TU BA EXAM READINESS DASHBOARD",
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
                                text = "$completedDays / 16 Days Done",
                                color = HighlightGreenDark,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // 4 Stat metric tiles
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Tile 1: Study Time
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = HighlightBlueLight,
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${totalHours}h ${remMinutes}m",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = HighlightBlueDark
                                )
                                Text("Study Time", fontSize = 10.sp, color = TextDarkGray)
                            }
                        }

                        // Tile 2: Exam Tests
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = HighlightGreenLight,
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${attempts.size}",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = HighlightGreenDark
                                )
                                Text("Mocks Taken", fontSize = 10.sp, color = TextDarkGray)
                            }
                        }

                        // Tile 3: Bookmarks
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = HighlightAmberLight,
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${bookmarks.size}",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = HighlightAmber
                                )
                                Text("Starred", fontSize = 10.sp, color = TextDarkGray)
                            }
                        }

                        // Tile 4: Notes
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = HighlightPurpleLight,
                            modifier = Modifier.weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${notes.size}",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = HighlightPurpleDark
                                )
                                Text("My Notes", fontSize = 10.sp, color = TextDarkGray)
                            }
                        }
                    }
                }
            }
        }

        // Quick Tools Row: 📝 70%+ Blueprint & 📖 Bilingual Glossary
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = CleanPureWhite,
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder),
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { viewModel.setAnswerStructureDialogVisible(true) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightBlueLight,
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.Lightbulb, contentDescription = null, tint = HighlightBlueDark, modifier = Modifier.size(18.dp))
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("70%+ Blueprint", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TextBlack)
                            Text("4-Box Answering", fontSize = 10.sp, color = TextDarkGray)
                        }
                    }
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = CleanPureWhite,
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder),
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { viewModel.setGlossaryDialogVisible(true) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = HighlightGreenLight,
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(Icons.Default.GTranslate, contentDescription = null, tint = HighlightGreenDark, modifier = Modifier.size(18.dp))
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("Glossary", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TextBlack)
                            Text("Eng ⇄ नेपाली terms", fontSize = 10.sp, color = TextDarkGray)
                        }
                    }
                }
            }
        }

        // Section: User Notes Header
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "My Revision Notes (${notes.size})",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextBlack
                )

                Button(
                    onClick = { viewModel.openNoteEditor(null) },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    modifier = Modifier.testTag("btn_add_note")
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(14.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Add Note", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        // Notes List
        if (notes.isEmpty()) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.NoteAdd, contentDescription = null, tint = TextMutedGray, modifier = Modifier.size(36.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("No personal notes yet", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = TextBlack)
                        Text("Jot down quick definitions or formulas for exam morning revision.", fontSize = 11.sp, color = TextDarkGray)
                    }
                }
            }
        } else {
            items(notes) { note ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = note.title,
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = TextBlack
                            )

                            Row {
                                IconButton(onClick = { viewModel.openNoteEditor(note) }, modifier = Modifier.size(28.dp)) {
                                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit", tint = HighlightBlueDark, modifier = Modifier.size(16.dp))
                                }
                                IconButton(onClick = { viewModel.deleteUserNote(note.id) }, modifier = Modifier.size(28.dp)) {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = HighlightRedDark, modifier = Modifier.size(16.dp))
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = note.content,
                            fontSize = 11.5.sp,
                            color = TextDarkGray,
                            lineHeight = 15.sp
                        )
                    }
                }
            }
        }

        // Section: Exam Attempt Logs
        if (attempts.isNotEmpty()) {
            item {
                Text(
                    text = "Recent Exam Practice Results",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextBlack
                )
            }

            items(attempts) { attempt ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = CleanPureWhite),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CleanBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = attempt.examTitle, fontSize = 12.5.sp, fontWeight = FontWeight.Bold, color = TextBlack)
                            Text(text = "${attempt.subject} • ${attempt.scoredMarks}/${attempt.totalMarks} Marks", fontSize = 11.sp, color = TextDarkGray)
                        }

                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = if (attempt.percentage >= 60) HighlightGreenLight else HighlightAmberLight
                        ) {
                            Text(
                                text = "${attempt.percentage.toInt()}% • ${attempt.tuDivision}",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (attempt.percentage >= 60) HighlightGreenDark else HighlightAmber,
                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    // Add / Edit Note Dialog
    if (showNoteDialog) {
        var noteTitle by remember { mutableStateOf(editingNote?.title ?: "") }
        var noteContent by remember { mutableStateOf(editingNote?.content ?: "") }
        var noteSubject by remember { mutableStateOf(editingNote?.subject ?: "General") }

        AlertDialog(
            onDismissRequest = { viewModel.closeNoteEditor() },
            title = {
                Text(
                    text = if (editingNote == null) "Create Exam Note" else "Edit Note",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = noteTitle,
                        onValueChange = { noteTitle = it },
                        label = { Text("Note Title (e.g. PRA Tools List)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = noteContent,
                        onValueChange = { noteContent = it },
                        label = { Text("Note Content & Bullet Points") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        maxLines = 6
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (noteTitle.isNotBlank()) {
                            viewModel.saveUserNote(noteTitle, noteSubject, noteContent, null)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = HighlightBlue)
                ) {
                    Text("Save Note")
                }
            },
            dismissButton = {
                TextButton(onClick = { viewModel.closeNoteEditor() }) {
                    Text("Cancel", color = TextDarkGray)
                }
            }
        )
    }
}
