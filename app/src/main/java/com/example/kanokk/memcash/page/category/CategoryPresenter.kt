package com.example.kanokk.memcash.page.category

import android.content.Context
import android.util.Log
import com.example.kanokk.memcash.application.MyApplication
import com.example.kanokk.memcash.database.maneger.MyDatabase
import com.example.kanokk.memcash.database.model.CategoryBase
import com.example.kanokk.memcash.model.Category
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CategoryPresenter : CategoryContract.Presenter {


    var v : CategoryContract.View?=null

    override fun preparedata(context: Context) {
        Log.d("Data : ", "PreData")
        MyApplication.myDatabase.categoryDao().getAllCategory()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { listOfPeople ->
                    v?.showdata(transfer(listOfPeople))
                }
    }

    override fun AddView(t: CategoryContract.View) {
        v = t
    }

    fun  transfer(datas : List<CategoryBase>):ArrayList<Category>{
        var items = ArrayList<Category>()

        for(d in datas){
            var item = Category(d.uid,d.code,d.name)
            items.add(item)
        }
        return items
    }

    override fun delcategory(item: Category, context: Context) {
        val category = CategoryBase(item.uid,item.code,item.name)
        Flowable.fromCallable {
            MyApplication.myDatabase.categoryDao().delete(category)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    v?.showmessage("delete complete")
                }
    }

}