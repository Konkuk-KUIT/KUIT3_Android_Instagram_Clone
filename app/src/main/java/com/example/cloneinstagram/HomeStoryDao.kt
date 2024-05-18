package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface HomeStoryDao {

    @Query("SELECT * FROM HomeStoryData")
    fun getALL(): MutableList<HomeStoryData>

    @Insert
    fun insert(homeStoryData: HomeStoryData)

    @Update
    fun update(homeStoryData: HomeStoryData)

    @Delete
    fun delete(homeStoryData: HomeStoryData)
}