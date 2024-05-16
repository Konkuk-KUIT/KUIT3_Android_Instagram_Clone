package com.example.cloneinstagram.home

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cloneinstagram.data.UsersData

@Database(entities = [UsersData::class], version = 1)
abstract class HomeStoryDB : RoomDatabase() {
    abstract fun HomeStoryDAO() : HomeStoryDAO

    companion object{
        private var instance: HomeStoryDB? = null

        @Synchronized
        fun getInstance(context: Context): HomeStoryDB?{

            if(instance == null){

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