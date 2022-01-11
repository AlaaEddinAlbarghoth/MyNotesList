package com.alaaeddinalbarghoth.mytodolist.di

import android.app.Application
import androidx.room.Room
import com.alaaeddinalbarghoth.mytodolist.features.note.data.repository.NoteRepositoryImpl
import com.alaaeddinalbarghoth.mytodolist.features.note.data.source.NoteDatabase
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.repository.NoteRepository
import com.alaaeddinalbarghoth.mytodolist.features.note.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(noteDatabase.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCase(noteRepository: NoteRepository): NoteUseCases =
        NoteUseCases(
            GetNotesUseCase(noteRepository),
            GetNoteUseCase(noteRepository),
            AddNoteUseCase(noteRepository),
            DeleteNoteUseCase(noteRepository)
        )
}
