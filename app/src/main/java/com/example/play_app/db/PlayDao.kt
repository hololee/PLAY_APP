package com.example.play_app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface PlayDao {
    @Query("SELECT * FROM play")
    fun getAll():List<Play>

    @Insert
    fun insertAll(vararg plays:Play)

    @Delete
    fun delete(play:Play)

}