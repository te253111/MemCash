package com.example.kanokk.memcash.page.category

import android.content.Context
import com.example.kanokk.memcash.base.BaseView
import com.example.kanokk.memcash.database.model.CategoryBase
import com.example.kanokk.memcash.model.Category

interface  CategoryContract {
    interface  View {
        fun showdata(data : List<Category>)
    }

    interface Presenter : BaseView<View> {
        fun preparedata(context : Context)
    }

}


