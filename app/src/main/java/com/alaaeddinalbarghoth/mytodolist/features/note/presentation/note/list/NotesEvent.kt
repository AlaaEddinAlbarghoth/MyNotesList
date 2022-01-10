package com.alaaeddinalbarghoth.mytodolist.features.note.presentation.note.list

import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.util.NoteOrder

sealed class NotesEvent {
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
}
