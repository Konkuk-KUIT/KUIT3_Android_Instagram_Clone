package com.example.clonecodinginstagram

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.clonecodinginstagram.PostData

@Entity
@Dao
interface HomePostDao {
    @Query("SELECT * FROM postdata")
    fun getAll() : MutableList<PostData>
    @Insert
    fun insert(postData: PostData)
    @Update
    fun update(postData: PostData)
    @Delete
    fun delete(postData: PostData)

}