package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemHomePostDao {

    @Query("SELECT * FROM ItemHomePostData")
    fun getItemHomePostData() : MutableList<ItemHomePostData>

    @Insert
    fun putItemHomePostData(homePostData: ItemHomePostData)

}