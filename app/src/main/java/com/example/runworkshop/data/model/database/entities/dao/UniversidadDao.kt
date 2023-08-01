package com.example.runworkshop.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.runworkshop.data.model.database.entities.UniversidadEntity

@Dao
interface UniversidadDao {

    @Query("SELECT * FROM universidades ORDER BY fecha DESC")
    suspend fun getAllUniversidades():List<UniversidadEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUniversidades(universidades:List<UniversidadEntity>)

    @Query("DELETE FROM universidades")
    suspend fun deleteAllUniversidades()
}