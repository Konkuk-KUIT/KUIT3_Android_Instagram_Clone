package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemHomePostData(
    val imageId : Int,
    val instagramId : String,
    val postingImageId : Int,
    val content : String
){
    @PrimaryKey(autoGenerate = true) var itemHomePostId:Int = 0
}
