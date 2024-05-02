package com.example.cloneinstagram

import java.io.Serializable
data class StoryData(
    val userImg: Int,
    val userId: String,
    var isSeen: Boolean
): Serializable
