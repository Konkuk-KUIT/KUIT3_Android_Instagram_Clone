package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class StoryData (
    val storyProfile: Int,
    val storyId: String
) : Serializable{
    @PrimaryKey(autoGenerate = true) var storyUid : Int = 0
}