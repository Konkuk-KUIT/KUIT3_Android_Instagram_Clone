package com.example.cloneinstagram.home

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cloneinstagram.data.PostData

@Database(entities = [PostData::class], version = 3)
abstract class HomePostDB : RoomDatabase() {
    abstract fun HomePostDAO() : HomePostDAO

    companion object{
        private var instance: HomePostDB? = null

        @Synchronized
        fun getInstance(context: Context): HomePostDB?{

            if(instance == null){

                synchronized(HomePostDB){
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