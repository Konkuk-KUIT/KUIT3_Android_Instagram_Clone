package com.example.cloneinstagram

import android.media.Image
import org.w3c.dom.Comment
import java.io.Serializable

data class PostData(
    val postProfile : Int,
    val postImage: Int,
    val postID: String,
    val postID2: String,
    val postComment: String
) : Serializable
