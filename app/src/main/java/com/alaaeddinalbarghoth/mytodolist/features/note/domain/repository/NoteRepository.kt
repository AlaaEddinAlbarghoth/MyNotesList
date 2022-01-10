package com.alaaeddinalbarghoth.mytodolist.features.note.domain.repository

import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/** You can use this interface to make a fake repository */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}
