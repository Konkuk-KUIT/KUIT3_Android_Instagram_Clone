package com.example.cloneinstagram.home

import android.widget.ImageView
import java.io.Serializable

data class UserData(
    val profileImage: Int = 0,
    val profileImageView: ImageView? = null,
    val profileUserId: String,
    val userName: String,
) : Serializable {
    class Builder {
        private var profileImage : Int = 0
        private var profileImageView: ImageView? = null
        private var profileUserId : String=""
        private var userName : String=""

        fun setProfileImage(profileImage: Int) = apply { this.profileImage = profileImage }
        fun setProfileImageView(profileImageView: ImageView?) = apply { this.profileImageView = profileImageView }
        fun setProfileUserId(profileUserId: String) = apply { this.profileUserId = profileUserId }
        fun setUserName(userName: String) = apply { this.userName = userName}

        fun build(): UserData {
            return UserData(profileImage, profileImageView, profileUserId, userName)
        }
    }
}
