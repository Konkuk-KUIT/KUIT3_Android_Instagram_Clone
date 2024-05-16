package com.example.cloneinstagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StoryData::class], version = 1)
abstract class StoryDB:RoomDatabase() {
    abstract fun StoryDao():StoryDao
    //싱글톤 패턴
    companion object{
        private var instance: StoryDB?=null
        @Synchronized
        fun getInstance(context: Context):StoryDB?{
            if(instance==null){
                synchronized(StoryDB){
                    instance= Room.databaseBuilder(
                        context,
                        StoryDB::class.java,
                        "story-database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return instance
        }
    }
}