package com.example.cloneinstagram

import java.io.Serializable

data class FollowingData (
    val followingImage: Int,
    val followingID: String,
    val followingName: String
) : Serializable