package com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase

data class NoteUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val getNoteUseCase: GetNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
)
