package com.example.cloneinstagram

import java.io.Serializable

data class FollowerData (
    val FollowerImage: Int,
    val FollowerID: String,
    val FollowerName: String
) : Serializable