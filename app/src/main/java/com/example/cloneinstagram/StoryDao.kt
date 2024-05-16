package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StoryDao {

    @Query("SELECT * FROM StoryData")
    fun getAll():MutableList<StoryData>
    @Insert
    fun insert(storyData: StoryData)
    @Delete
    fun delete(storyData: StoryData)
    @Update
    fun update(storyData: StoryData)
}