package com.example.runworkshop.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.runworkshop.data.model.database.entities.dao.InstitutoDao

@Database(entities = [InstitutoEntity::class], version = 1)
abstract class InstitutoDatabase:RoomDatabase() {

    abstract fun getInstitutoDao():InstitutoDao

}