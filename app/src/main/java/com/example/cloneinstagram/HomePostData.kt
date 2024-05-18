package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class HomePostData(
    val InstagramID: String,
    val ProfileImage: Int,
    val PostImage: Int,
    val PostComment: String
) : Serializable {
    @PrimaryKey(autoGenerate = true) var userUid: Int = 0
}


