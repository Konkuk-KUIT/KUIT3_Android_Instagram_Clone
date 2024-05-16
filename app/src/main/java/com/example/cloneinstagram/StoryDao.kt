package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StoryDao {
    @Query("SELECT*FROM StoryData")
    fun getAll():MutableList<StoryData>
    @Insert
    fun insert(StoryData: StoryData)
    @Delete
    fun delete(StoryData: StoryData)
    @Update
    fun update(StoryData: StoryData)
}