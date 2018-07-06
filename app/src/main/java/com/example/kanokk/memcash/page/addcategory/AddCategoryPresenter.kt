package com.example.kanokk.memcash.page.addcategory

import android.content.Context
import android.util.Log
import com.example.kanokk.memcash.database.maneger.MyDatabase
import com.example.kanokk.memcash.database.model.CategoryBase
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddCategoryPresenter : AddCategoryContract.Presenter{


    var v : AddCategoryContract.View? = null

    override fun preparedata() {

    }

    override fun addcategory(code: String, name: String, context: Context) {
        val category = CategoryBase(0,code,name)
        val appDatabase = MyDatabase.getAppDatabase(context)

        Flowable.fromCallable {
            appDatabase.categoryDao().insert(category)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    v?.showmessage("insert complete")
                }
    }

    override fun AddView(t: AddCategoryContract.View) {
        v = t
    }

}