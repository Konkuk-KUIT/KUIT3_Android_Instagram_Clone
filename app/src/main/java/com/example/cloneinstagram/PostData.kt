package com.example.cloneinstagram

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class PostData(
    val postImgId:Int,
    val profileImgId:Int,
    val postId:String,
    val postContent:String
) :Serializable{
    @PrimaryKey(autoGenerate = true) var userUid:Int=0
}