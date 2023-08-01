package com.example.runworkshop.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.runworkshop.data.model.database.entities.ConsultoraEntity

@Dao
interface ConsultoraDao {

    @Query("SELECT * FROM consultoras ORDER BY fecha DESC")
    suspend fun getAllConsultoras():List<ConsultoraEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllConsultoras(consultoras:List<ConsultoraEntity>)

    @Query("DELETE FROM consultoras")
    suspend fun deleteAllConsultoras()
}