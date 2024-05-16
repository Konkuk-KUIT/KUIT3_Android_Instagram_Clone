package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeStoryData(
    val imageId : Int,
    val instagramId : String
){
    @PrimaryKey(autoGenerate = true) var homeStoryId:Int = 0
}
