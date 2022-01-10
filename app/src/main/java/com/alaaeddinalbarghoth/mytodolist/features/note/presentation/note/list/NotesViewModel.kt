package com.alaaeddinalbarghoth.mytodolist.features.note.presentation.note.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase.NoteUseCases
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.util.NoteOrder
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/* In Clean Architecture the use of vm is to make a use of use cases, and take the results from them */
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {

    private var getNotesJob: Job? = null

    private var recentlyDeletedNote: Note? = null

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    init {
        getNotesJob(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(notesEvent: NotesEvent) {
        when (notesEvent) {
            is NotesEvent.Order -> {
                if (state.value.noteOrder::class == notesEvent.noteOrder::class &&
                    state.value.noteOrder.orderType == notesEvent.noteOrder.orderType
                ) {
                    return
                }
                getNotesJob(notesEvent.noteOrder)
            }
            is NotesEvent.DeleteNote -> viewModelScope.launch {
                recentlyDeletedNote = notesEvent.note
                useCases.deleteNoteUseCase(notesEvent.note)
            }
            is NotesEvent.RestoreNote -> viewModelScope.launch {
                useCases.addNoteUseCase(recentlyDeletedNote ?: return@launch)
                recentlyDeletedNote = null
            }
            is NotesEvent.ToggleOrderSection -> _state.value = state.value.copy(
                isOrderSectionVisible = !state.value.isOrderSectionVisible
            )
        }
    }

    private fun getNotesJob(noteOrder: NoteOrder) {
        getNotesJob?.cancel()

        getNotesJob = useCases.getNotesUseCase(noteOrder).onEach { notes ->
            _state.value = state.value.copy(
                notes = notes,
                noteOrder = noteOrder
            )
        }.launchIn(viewModelScope)
    }
}
