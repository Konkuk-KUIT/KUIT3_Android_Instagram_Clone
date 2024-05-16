package com.example.cloneinstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PostDao {
    @Query("SELECT * FROM PostData")
    fun getAll():MutableList<PostData>
    @Insert
    fun insert(PostData: PostData)

    @Update
    fun update(PostData: PostData)

    @Delete
    fun delete(PostData: PostData)
}