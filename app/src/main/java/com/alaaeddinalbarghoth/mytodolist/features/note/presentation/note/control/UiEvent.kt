package com.alaaeddinalbarghoth.mytodolist.features.note.presentation.note.control

sealed class UiEvent {
    object SaveNote : UiEvent()
    data class ShowSnackBar(val message: String) : UiEvent()
}
