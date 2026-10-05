package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingProgressDao {
    @Query("SELECT * FROM reading_day_progress ORDER BY dayNumber ASC")
    fun getAllProgress(): Flow<List<ReadingDayProgressEntity>>

    @Query("SELECT * FROM reading_day_progress WHERE dayNumber = :dayNumber LIMIT 1")
    suspend fun getProgressForDay(dayNumber: Int): ReadingDayProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProgress(progress: ReadingDayProgressEntity)

    @Query("UPDATE reading_day_progress SET isCompleted = :completed, completedTimestamp = :timestamp WHERE dayNumber = :dayNumber")
    suspend fun setDayCompleted(dayNumber: Int, completed: Boolean, timestamp: Long?)

    @Query("UPDATE reading_day_progress SET minutesSpent = minutesSpent + :addedMinutes WHERE dayNumber = :dayNumber")
    suspend fun addMinutesSpent(dayNumber: Int, addedMinutes: Int)

    @Query("DELETE FROM reading_day_progress")
    suspend fun resetAllProgress()
}

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY savedTimestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE materialId = :materialId)")
    fun isBookmarked(materialId: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE materialId = :materialId")
    suspend fun removeBookmark(materialId: String)
}

@Dao
interface ExamAttemptDao {
    @Query("SELECT * FROM exam_attempts ORDER BY timestamp DESC")
    fun getAllAttempts(): Flow<List<ExamAttemptEntity>>

    @Query("SELECT * FROM exam_attempts ORDER BY timestamp DESC LIMIT 5")
    fun getRecentAttempts(): Flow<List<ExamAttemptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun recordAttempt(attempt: ExamAttemptEntity): Long

    @Query("DELETE FROM exam_attempts WHERE attemptId = :id")
    suspend fun deleteAttempt(id: Long)
}

@Dao
interface UserNoteDao {
    @Query("SELECT * FROM user_notes ORDER BY updatedAt DESC")
    fun getAllNotes(): Flow<List<UserNoteEntity>>

    @Query("SELECT * FROM user_notes WHERE id = :id LIMIT 1")
    suspend fun getNoteById(id: Long): UserNoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: UserNoteEntity): Long

    @Update
    suspend fun updateNote(note: UserNoteEntity)

    @Query("DELETE FROM user_notes WHERE id = :id")
    suspend fun deleteNote(id: Long)
}
