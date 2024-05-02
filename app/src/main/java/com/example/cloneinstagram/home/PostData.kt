package com.example.cloneinstagram.home

import android.widget.ImageView
import java.io.Serializable

data class PostData(
    val profileImage: Int = 0,
    val profileImageView: ImageView? = null,
    val profileUserId: String,
    val postImage: Int = 0,
    val postContent: String,
    val postImageURL: String = ""
) : Serializable {
    class Builder {
        private var profileImage : Int = 0
        private var profileImageView: ImageView? = null
        private var profileUserId : String=""
        private var postImage: Int = 0
        private var postContent: String = ""
        private var postImageURL: String = ""

        fun setProfileImage(profileImage: Int) = apply { this.profileImage = profileImage }
        fun setProfileImageView(profileImageView: ImageView?) = apply { this.profileImageView = profileImageView }
        fun setProfileUserId(profileUserId: String) = apply { this.profileUserId = profileUserId }
        fun setPostImage(postImage: Int) = apply { this.postImage = postImage }
        fun setPostContent(postContent: String) = apply { this.postContent = postContent }
        fun setPostImageURL(postImageURL: String) = apply { this.postImageURL = postImageURL }

        fun build(): PostData {
            return PostData(profileImage, profileImageView, profileUserId, postImage, postContent, postImageURL)
        }
    }
}
