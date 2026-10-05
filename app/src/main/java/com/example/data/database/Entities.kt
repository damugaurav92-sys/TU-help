package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_day_progress")
data class ReadingDayProgressEntity(
    @PrimaryKey val dayNumber: Int,
    val isCompleted: Boolean = false,
    val minutesSpent: Int = 0,
    val completedTimestamp: Long? = null,
    val notes: String = ""
)

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val materialId: String,
    val savedTimestamp: Long = System.currentTimeMillis(),
    val customNote: String = ""
)

@Entity(tableName = "exam_attempts")
data class ExamAttemptEntity(
    @PrimaryKey(autoGenerate = true) val attemptId: Long = 0,
    val examTitle: String,
    val subject: String,
    val mode: String,
    val totalQuestions: Int,
    val correctCount: Int,
    val totalMarks: Double,
    val scoredMarks: Double,
    val percentage: Double,
    val tuDivision: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_notes")
data class UserNoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val subject: String,
    val content: String,
    val relatedMaterialId: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
