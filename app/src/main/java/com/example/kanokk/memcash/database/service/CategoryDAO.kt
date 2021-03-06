package com.example.kanokk.memcash.database.service

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.kanokk.memcash.database.model.CategoryBase
import io.reactivex.Flowable
import android.arch.persistence.room.Delete



@Dao
interface CategoryDAO{
    @Query("SELECT * FROM cateory")
    fun getAllCategory(): Flowable<List<CategoryBase>>

    @Insert
    fun insert(categorybase: CategoryBase)

    @Update
    fun update(categorybase: CategoryBase)

    @Delete
    fun delete(categorybase: CategoryBase)
}