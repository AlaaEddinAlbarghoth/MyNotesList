package com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase

import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.repository.NoteRepository
import com.alaaeddinalbarghoth.mytodolist.utils.InvalidNoteException

class AddNoteUseCase(private val noteRepository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("The title of the note can't be empty.")

        if (note.content.isBlank())
            throw InvalidNoteException("The title of the note can't be empty.")

        noteRepository.insertNote(note)
    }
}
