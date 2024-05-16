package com.example.cloneinstagram

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class PostData(
    val profileImg: Int,
    val userId: String,
    val postImg: Int,
    val postContent: String,
) : Serializable {
    @PrimaryKey(autoGenerate = true) var userUid: Int = 0
}
