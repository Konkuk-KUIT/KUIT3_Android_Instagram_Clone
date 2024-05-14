package com.example.cloneinstagram.home

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostData::class], version = 2)
abstract class HomePostDB : RoomDatabase() {
    abstract fun HomePostDAO() : HomePostDAO

    // 2번 싱글톤 패턴
    companion object{
        private var instance: HomePostDB? = null

        @Synchronized
        fun getInstance(context: Context): HomePostDB?{
            Log.d("1", "1")

            if(instance == null){
                Log.d("2", "2")

                synchronized(HomePostDB){
                    instance = Room.databaseBuilder(
                        context,
                        HomePostDB::class.java,
                        "homepost-database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            Log.d("3", "3")
            return instance
        }
    }
}