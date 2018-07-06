package com.example.kanokk.memcash.database.maneger

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.kanokk.memcash.database.model.CategoryBase
import com.example.kanokk.memcash.database.service.CategoryDAO

@Database(entities = arrayOf(CategoryBase::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    companion object {
        fun getAppDatabase(context: Context): MyDatabase =
                Room.databaseBuilder(context, MyDatabase::class.java, "db_app").build()
    }

    abstract fun categoryDao(): CategoryDAO
}