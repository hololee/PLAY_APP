package com.example.play_app.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.example.play_app.db.entity.Play

@Dao
interface PlayDao {
    @Query("SELECT * FROM play")
    fun getAll():List<Play>

    @Query("SELECT * FROM play WHERE place = '실내'")
    fun getIndoor():List<Play>

    @Query("SELECT * FROM play WHERE place = '실외'")
    fun getOutdoor():List<Play>

    @Query("SELECT * FROM play WHERE cost = '무료'")
    fun getFree():List<Play>

    @Query("SELECT * FROM play WHERE cost = '유료'")
    fun getPay():List<Play>

    @Query("SELECT * FROM play WHERE cost = '혼자서'")
    fun getAlone():List<Play>

    @Query("SELECT * FROM play WHERE cost = '여럿이서'")
    fun getFriend():List<Play>

    @Query("SELECT * FROM play WHERE cost = '활동적'")
    fun getActive():List<Play>

    @Query("SELECT * FROM play WHERE cost = '비활동적'")
    fun getInActive():List<Play>

    @Insert
    fun insert(play: Play)

    @Delete
    fun delete(play: Play)

}