package com.example.play_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Play::class),version = 1)
abstract class PlayDatabase : RoomDatabase(){
    abstract fun playDao(): PlayDao

    companion object {
        private var INSTANCE : PlayDatabase? = null

        fun getInstance(context:Context) : PlayDatabase? {
            if(INSTANCE == null){
                synchronized(PlayDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,PlayDatabase::class.java,"play-db").build();
                }
            }
            return INSTANCE
        }
    }
}