package com.example.cloneinstagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StoryData::class], version = 2)
abstract class HomeStoryDB: RoomDatabase() {
    abstract fun HomeStoryDao(): HomeStoryDao

    companion object{
        private var instance: HomeStoryDB? = null

        @Synchronized
        fun getInstance(context: Context): HomeStoryDB? {
            if (instance == null) {
                synchronized(HomeStoryDB){
                    instance = Room.databaseBuilder(
                        context,
                        HomeStoryDB::class.java,
                        "homestory-database"
                    ).fallbackToDestructiveMigration().build()
                }
            }

            return instance
        }
    }
}