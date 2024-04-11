package com.example.cloneinstagram

import java.io.Serializable

data class UserData(
    val UserImg: Int,
    val UserId: String,
    val UserName: String
): Serializable
