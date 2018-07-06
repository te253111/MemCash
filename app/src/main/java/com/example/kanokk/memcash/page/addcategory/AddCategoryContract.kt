package com.example.kanokk.memcash.page.addcategory

import android.content.Context
import com.example.kanokk.memcash.base.BaseView
import com.example.kanokk.memcash.model.Category

interface AddCategoryContract{

    interface  View  {
        fun showmessage(mess : String)
    }

    interface Presenter : BaseView<View> {
        fun preparedata()
        fun addcategory(code : String,name : String,context : Context)
    }
}