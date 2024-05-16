package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HomeStoryDao {

    @Query("SELECT * FROM HomeStoryData")
    fun getHomeStoryData() : MutableList<HomeStoryData>

    @Insert
    fun putHomeStoryData(homeStoryData: HomeStoryData)

}