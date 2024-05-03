package com.example.cloneinstagram

import java.io.Serializable

data class StoryData (
    val storyProfile: Int,
    val storyId: String
) : Serializable