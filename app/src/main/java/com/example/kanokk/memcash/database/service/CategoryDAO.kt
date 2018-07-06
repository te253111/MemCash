package com.example.kanokk.memcash.database.service

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.kanokk.memcash.database.model.CategoryBase
import io.reactivex.Flowable

@Dao
interface CategoryDAO{
    @Query("SELECT * FROM cateory")
    fun getAllPeople(): Flowable<List<CategoryBase>>

    @Insert
    fun insert(categorybase: CategoryBase)
}