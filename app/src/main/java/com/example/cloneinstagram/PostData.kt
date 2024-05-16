package com.example.cloneinstagram

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Comment
import java.io.Serializable

@Entity
data class PostData(
    val postProfile : Int,
    val postImage: Int,
    val postID: String,
    val postName:String,
    val postID2: String,
    val postComment: String
) : Serializable{
    @PrimaryKey(autoGenerate = true) var userUid: Int=0
}
