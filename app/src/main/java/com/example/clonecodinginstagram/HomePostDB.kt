package com.example.clonecodinginstagram

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PostData::class], version = 1)
abstract class HomePostDB : RoomDatabase(){
    abstract fun HomePostDao(): HomePostDao
}