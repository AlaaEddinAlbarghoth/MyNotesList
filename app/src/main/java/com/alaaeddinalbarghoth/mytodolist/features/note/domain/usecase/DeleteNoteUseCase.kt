package com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase

import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) =
        noteRepository.deleteNote(note)
}