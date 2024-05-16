package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class StoryData(
    val userImg: Int,
    val userId: String,
    var isSeen: Boolean,
    var isMyStory: Boolean
): Serializable {
    @PrimaryKey(autoGenerate = true) var userUid: Int = 0
}
