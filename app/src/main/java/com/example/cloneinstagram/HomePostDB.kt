package com.example.cloneinstagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [HomePostData::class], version = 2)
abstract class HomePostDB : RoomDatabase() {
    abstract fun HomePostDao() : HomePostDao

    companion object{
        private var instance: HomePostDB? = null

        @Synchronized
        fun getInstance(context: Context) : HomePostDB?{
            if(instance == null){
                synchronized(HomePostDB) {
                    instance = Room.databaseBuilder(
                        context,
                        HomePostDB::class.java,
                        "homepost-database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return instance
        }
    }
}