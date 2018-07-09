package com.example.kanokk.memcash.application

import android.app.Application
import com.example.kanokk.memcash.database.maneger.MyDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        myDatabase = MyDatabase.getAppDatabase(applicationContext)
    }

    companion object {
        lateinit var myDatabase : MyDatabase
    }
}