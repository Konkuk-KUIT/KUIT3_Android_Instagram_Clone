package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeStoryData(
    val InstagramID: String,
    val ProfileImage: Int,
) {
    @PrimaryKey(autoGenerate = true) var userUid: Int = 0
}