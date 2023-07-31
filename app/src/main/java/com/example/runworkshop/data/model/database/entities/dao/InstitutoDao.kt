package com.example.runworkshop.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.runworkshop.data.model.database.entities.InstitutoEntity

@Dao
interface InstitutoDao {

    @Query("SELECT * FROM institutos ORDER BY fecha")
    suspend fun getAllInstitutos():List<InstitutoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllInstitutos(institutos:List<InstitutoEntity>)

    @Query("DELETE FROM institutos")
    suspend fun deleteAllInstitutos()
}