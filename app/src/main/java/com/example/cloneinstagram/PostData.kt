package com.example.cloneinstagram

import java.io.Serializable

data class PostData(
    val profileImage : Int,
    val profileName : String,
    val postImage : Int,
    val postText : String
) : Serializable
