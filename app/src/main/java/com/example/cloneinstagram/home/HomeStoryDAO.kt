package com.example.cloneinstagram.home

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cloneinstagram.data.UsersData

@Dao
interface HomeStoryDAO {
    @Query("SELECT * FROM UsersData")
    fun getAll(): MutableList<UsersData>
    @Insert
    fun insert(usersData: UsersData)
    @Update
    fun update(usersData: UsersData)
    @Delete
    fun delete(usersData: UsersData)
}