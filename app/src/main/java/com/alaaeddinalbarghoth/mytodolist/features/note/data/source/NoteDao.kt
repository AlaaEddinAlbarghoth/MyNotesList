package com.alaaeddinalbarghoth.mytodolist.features.note.data.source

import androidx.room.*
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    /** We return a flow here and we can't use suspend fun */
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    /** This is a suspend function bcz we return a note here */
    @Query("SELECT * FROM note where id = :id")
    suspend fun getNoteById(id: Int): Note?

    /** This is a suspend function bcz we return a note here */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    /** This is a suspend function bcz we return a note here */
    @Delete
    suspend fun deleteNote(note: Note)
}
