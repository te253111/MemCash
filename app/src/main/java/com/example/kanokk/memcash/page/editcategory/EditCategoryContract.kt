package com.example.kanokk.memcash.page.editcategory

import android.content.Context
import com.example.kanokk.memcash.base.BaseView
import com.example.kanokk.memcash.model.Category

interface EditCategoryContract{
    interface  View  {
        fun showmessage(mess : String)
    }

    interface Presenter : BaseView<View> {
        fun preparedata()
        fun editcategory(uid:Long, code:String , name:String , context : Context)
    }
}
