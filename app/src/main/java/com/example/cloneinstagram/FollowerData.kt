package com.example.cloneinstagram

import java.io.Serializable

data class FollowerData (
    val followerImage: Int,
    val followerID: String,
    val followerName: String
) : Serializable