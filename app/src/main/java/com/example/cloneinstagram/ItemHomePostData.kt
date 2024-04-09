package com.example.cloneinstagram

import java.io.Serializable

data class ItemHomePostData(
    val imageId : Int,
    val instagramId : String,
    val postingImageId : Int,
    val content : String
)
