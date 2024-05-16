package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class StoryData (
    @PrimaryKey val userId:String="kuit.official",
    val storyImg:Int
):Serializable