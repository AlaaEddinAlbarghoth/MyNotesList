package com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase

import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? =
        noteRepository.getNoteById(id)
}
