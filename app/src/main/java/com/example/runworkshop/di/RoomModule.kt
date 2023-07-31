package com.example.runworkshop.di

import android.content.Context
import androidx.room.Room
import com.example.runworkshop.data.model.database.entities.RunWorkshopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "rw_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, RunWorkshopDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideInstitutoDao(db:RunWorkshopDatabase) = db.getInstitutoDao()
}