package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HomePostDao {
    @Query("SELECT * FROM PostData")
    fun getAll(): MutableList<PostData>

    @Insert
    fun insert(postData: PostData)
    @Update
    fun update(postData: PostData)
    @Delete
    fun delete(postData: PostData)
}