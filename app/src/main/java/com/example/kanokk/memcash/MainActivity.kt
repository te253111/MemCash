package com.example.kanokk.memcash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kanokk.memcash.page.addcategory.AddCategoryFragment
import com.example.kanokk.memcash.page.category.CategoryFragment

class MainActivity : AppCompatActivity(),CategoryFragment.Listener,AddCategoryFragment.Listener {

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
        transaction.commit()
    }

    override fun gotoCategory() {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContent, CategoryFragment.newInstance())
        transaction.commit()
    }
}
