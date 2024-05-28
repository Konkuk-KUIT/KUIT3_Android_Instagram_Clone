package com.example.clonecodinginstagram

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class PostData(
    val user_profile_image : Int,
    val user_id : String,
    //val post_image : Int,
    val post_content : String
) : Serializable{
    @PrimaryKey(autoGenerate = true) var userUid : Int = 0
}
