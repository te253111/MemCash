package com.example.kanokk.memcash.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "cateory")
data class CategoryBase(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var code: String = "",
        var name: String = ""
)

