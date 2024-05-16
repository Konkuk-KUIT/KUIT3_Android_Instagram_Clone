package com.example.cloneinstagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [ItemHomePostData::class, HomeStoryData::class], version = 1)
abstract class HomeDB:RoomDatabase() {

    abstract fun ItemHomePostDao() : ItemHomePostDao
    abstract fun HomeStoryDao() : HomeStoryDao

    companion object{
        private var instance : HomeDB? = null

        @OptIn(InternalCoroutinesApi::class)
        @Synchronized
        fun getInstance (context: Context):HomeDB?{
            synchronized(HomeDB){
                if(instance == null){
                    instance = Room.databaseBuilder(context, HomeDB::class.java, "HomeDB").allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}