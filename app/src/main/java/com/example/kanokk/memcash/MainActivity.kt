package com.example.kanokk.memcash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kanokk.memcash.model.Category
import com.example.kanokk.memcash.page.addcategory.AddCategoryFragment
import com.example.kanokk.memcash.page.category.CategoryFragment
import com.example.kanokk.memcash.page.editcategory.EditCategoryFragment

class MainActivity : AppCompatActivity(),CategoryFragment.Listener,AddCategoryFragment.Listener,EditCategoryFragment.Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, CategoryFragment.newInstance())
        transaction.commit()
    }

    override fun gotoAddCategory() {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, AddCategoryFragment.newInstance())
        transaction.addToBackStack("add")
        transaction.commit()
    }

    override fun gotoCategory() {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, CategoryFragment.newInstance())
        transaction.commit()
    }

    override fun gotoEditCategory(item : Category) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, EditCategoryFragment.newInstance(item))
        transaction.addToBackStack("edit")
        transaction.commit()
    }

    override fun gotoCategoryfromedit() {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, CategoryFragment.newInstance())
        transaction.commit()
    }

}
