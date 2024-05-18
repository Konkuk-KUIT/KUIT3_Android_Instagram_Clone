package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cloneinstagram.HomePostData

@Dao
interface HomePostDao {

    @Query("SELECT * FROM HomePostData")
    fun getALL(): MutableList<HomePostData>

    @Insert
    fun insert(homePostData: HomePostData)

    @Update
    fun update(homePostData: HomePostData)

    @Delete
    fun delete(homePostData: HomePostData)
}