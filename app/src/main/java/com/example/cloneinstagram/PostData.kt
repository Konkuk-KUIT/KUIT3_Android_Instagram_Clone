package com.example.cloneinstagram

import android.media.Image
import java.io.Serializable

data class PostData(
    val profileImgId:Int,
    val postId:String,
    val postImgId:Int,
    val postContent:String

) :Serializable
