package com.example.kanokk.memcash.page.editcategory

import android.content.Context
import com.example.kanokk.memcash.application.MyApplication
import com.example.kanokk.memcash.database.maneger.MyDatabase
import com.example.kanokk.memcash.database.model.CategoryBase
import com.example.kanokk.memcash.model.Category
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EditCategoryPresenter : EditCategoryContract.Presenter{

    var v : EditCategoryContract.View? = null

    override fun preparedata() {

    }

    override fun editcategory(uid: Long, code: String, name: String, context: Context) {
        val category = CategoryBase(uid,code,name)

        Flowable.fromCallable {
            MyApplication.myDatabase.categoryDao().update(category)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    v?.showmessage("edit complete")
                }
    }

    override fun AddView(t: EditCategoryContract.View) {
        v = t
    }

}