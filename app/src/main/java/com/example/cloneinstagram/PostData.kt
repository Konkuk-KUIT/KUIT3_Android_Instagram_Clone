package com.example.cloneinstagram

import java.io.Serializable

data class PostData(
    val profileImage : Int,
    val profileUserId : String,
    val postImage : Int,
    val postContent : String
) : Serializable
