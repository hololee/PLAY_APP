package com.example.play_app.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Play (
    @PrimaryKey val playId:Int,
    @ColumnInfo(name = "play_name") val name:String?,
    @ColumnInfo(name = "place") val place:Boolean?,
    @ColumnInfo(name = "cost") val cost:Boolean?,
    @ColumnInfo(name = "num") val num:Boolean?,
    @ColumnInfo(name = "act") val act: Boolean?
)