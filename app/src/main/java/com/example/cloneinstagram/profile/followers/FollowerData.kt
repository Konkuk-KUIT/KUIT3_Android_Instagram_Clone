package com.example.cloneinstagram.profile.followers

import java.io.Serializable

data class FollowerData(
    val followerImage : Int,
    val followerName : String,
    val followerUserId : String
) : Serializable
