package com.example.cloneinstagram.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class UsersData(
    val profileImage: Int,
    val profileImageUrl: String,
    val profileUserId: String,
    val userName: String,
) : Serializable {
    @PrimaryKey(autoGenerate = true) var userStoryId: Int = 0
    class Builder {
        private var profileImage : Int = 0
        private var profileImageUrl : String=""
        private var profileUserId : String=""
        private var userName : String=""

        fun setProfileImage(profileImage: Int) = apply { this.profileImage = profileImage }
        fun setProfileImageUrl(profileImageUrl: String) = apply { this.profileImageUrl = profileImageUrl}
        fun setProfileUserId(profileUserId: String) = apply { this.profileUserId = profileUserId }
        fun setUserName(userName: String) = apply { this.userName = userName}

        fun build(): UsersData {
            return UsersData(profileImage, profileImageUrl, profileUserId, userName)
        }
    }
}
