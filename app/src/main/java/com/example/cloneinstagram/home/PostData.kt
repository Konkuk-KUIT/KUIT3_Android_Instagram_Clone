package com.example.cloneinstagram.home

import android.widget.ImageView
import java.io.Serializable

data class PostData(
    val profileImage: Int,
    val profileImageUrl: String,
    val profileUserId: String,
    val profileName: String,
    val postImage: Int,
    val postImageURL: String,
    val postContent: String,
) : Serializable {
    class Builder {
        private var profileImage : Int = 0
        private var profileImageUrl: String =""
        private var profileUserId : String=""
        private var profileName : String=""
        private var postImage: Int = 0
        private var postImageURL: String = ""
        private var postContent: String = ""

        fun setProfileImage(profileImage: Int) = apply { this.profileImage = profileImage }
        fun setprofileImageUrl(profileImageUrl: String) = apply { this.profileImageUrl = profileImageUrl }
        fun setProfileUserId(profileUserId: String) = apply { this.profileUserId = profileUserId }
        fun setProfileName(profileName: String) = apply { this.profileName = profileName }
        fun setPostImage(postImage: Int) = apply { this.postImage = postImage }
        fun setPostImageURL(postImageURL: String) = apply { this.postImageURL = postImageURL }
        fun setPostContent(postContent: String) = apply { this.postContent = postContent }

        fun build(): PostData {
            return PostData(profileImage, profileImageUrl, profileUserId, profileName, postImage, postImageURL, postContent)
        }
    }
}
