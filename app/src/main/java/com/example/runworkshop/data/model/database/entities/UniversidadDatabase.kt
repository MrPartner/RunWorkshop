package com.example.runworkshop.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.runworkshop.data.model.database.entities.dao.UniversidadDao

@Database(entities = [UniversidadEntity::class], version = 1)
abstract class UniversidadDatabase : RoomDatabase() {

    abstract fun getUniversidadDao(): UniversidadDao

}