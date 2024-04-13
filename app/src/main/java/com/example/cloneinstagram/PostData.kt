package com.example.cloneinstagram

import android.media.Image
import java.io.Serializable

data class PostData(
    val postImgId:Int,
    val profileImgId:Int,
    val postId:String,
    val postContent:String
) :Serializable
