package com.example.cloneinstagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PostData::class, StoryData::class], version = 2)
abstract class PostDB :RoomDatabase(){
    abstract fun PostDao() : PostDao
    abstract fun StoryDao() : StoryDao
    companion object{
        private var instance: PostDB? = null
        //context는 받아와야 함. 자기 자신 리턴(PostDB)
        fun getinstance(context: Context): PostDB?{
            if(instance == null){
                synchronized(PostDB){
                    instance = Room.databaseBuilder(
                        context,
                        PostDB::class.java,
                        "post-database"
                    ).fallbackToDestructiveMigration().build()
                }

            }
            return instance
        }
    }
}