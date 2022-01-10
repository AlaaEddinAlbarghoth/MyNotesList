package com.alaaeddinalbarghoth.mytodolist.features.note.presentation.note.control

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent {
    object SaveNote : AddEditNoteEvent()
    data class ChangeColor(val color: Int) : AddEditNoteEvent()
    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent()
}
