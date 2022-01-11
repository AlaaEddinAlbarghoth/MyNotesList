package com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase

import com.alaaeddinalbarghoth.mytodolist.features.note.data.repository.FakeNoteRepository
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.model.Note
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.util.NoteOrder
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.util.OrderType
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesUseCaseTest {

    private lateinit var getNotesUseCase: GetNotesUseCase
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setup() {
        fakeNoteRepository = FakeNoteRepository()
        getNotesUseCase = GetNotesUseCase(fakeNoteRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }
        notesToInsert.shuffle()

        notesToInsert.forEach {
            runBlocking {
                fakeNoteRepository.insertNote(it)
            }
        }
    }

    @Test
    fun `Order Notes By title ascending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Title(OrderType.Ascending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].title).isLessThan(notes[i + 1].title)
    }

    @Test
    fun `Order Notes By title descending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Title(OrderType.Descending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].title).isGreaterThan(notes[i + 1].title)
    }

    @Test
    fun `Order Notes By date ascending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Date(OrderType.Ascending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].timestamp).isLessThan(notes[i + 1].timestamp)
    }

    @Test
    fun `Order Notes By date descending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Date(OrderType.Descending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].timestamp).isGreaterThan(notes[i + 1].timestamp)
    }

    @Test
    fun `Order Notes By color ascending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Color(OrderType.Ascending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].timestamp).isLessThan(notes[i + 1].timestamp)
    }

    @Test
    fun `Order Notes By color descending, correct order`() = runBlocking {
        val notes = getNotesUseCase(noteOrder = NoteOrder.Color(OrderType.Descending)).first()
        for (i in 0..notes.size - 2)
            assertThat(notes[i].color).isGreaterThan(notes[i + 1].color)
    }
}
