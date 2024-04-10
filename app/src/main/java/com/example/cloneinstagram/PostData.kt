package com.example.cloneinstagram

import java.io.Serializable

data class PostData(
    val profileImg: Int,
    val userId: String,
    val postImg: Int,
    val postContent: String
) : Serializable
