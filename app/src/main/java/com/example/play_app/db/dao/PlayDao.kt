package com.example.play_app.db.dao

import androidx.room.*
import com.example.play_app.db.entity.Play

@Dao
interface PlayDao {
    @Query("SELECT * FROM play")
    fun getAll():List<Play>

    @Query("SELECT * FROM play " +
            "WHERE place IN (:indoor, :outdoor) " +
            "AND   cost IN (:free, :pay) " +
            "AND   num  IN (:alone, :friend) " +
            "AND   act  IN (:active, :inactive) " +
            "ORDER BY random() " +
            "LIMIT 1")
    fun getResult(indoor:String?,outdoor:String?,free:String?,pay:String?,alone:String?,friend:String?,active:String?,inactive:String?):Play

//    @Query("SELECT * FROM play WHERE place = '실내'")
//    fun getIndoor():List<Play>
//
//    @Query("SELECT * FROM play WHERE place = '실외'")
//    fun getOutdoor():List<Play>
//
//    @Query("SELECT * FROM play WHERE cost = '무료'")
//    fun getFree():List<Play>
//
//    @Query("SELECT * FROM play WHERE cost = '유료'")
//    fun getPay():List<Play>
//
//    @Query("SELECT * FROM play WHERE num = '혼자서'")
//    fun getAlone():List<Play>
//
//    @Query("SELECT * FROM play WHERE num = '여럿이서'")
//    fun getFriend():List<Play>
//
//    @Query("SELECT * FROM play WHERE act = '활동적'")
//    fun getActive():List<Play>
//
//    @Query("SELECT * FROM play WHERE act = '비활동적'")
//    fun getInActive():List<Play>

    @Insert
    fun insert(play: Play)

    @Delete
    fun delete(play: Play)

    @Update
    fun update(play: Play)

}