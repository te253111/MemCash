package com.example.kanokk.memcash.page.category

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.kanokk.memcash.R
import com.example.kanokk.memcash.adapter.CategoryAdapter
import com.example.kanokk.memcash.database.model.CategoryBase
import com.example.kanokk.memcash.model.Category
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() ,CategoryContract.View {

    var presenter = CategoryPresenter()

    var listener : Listener? = null

    interface Listener{
        fun gotoAddCategory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.AddView(this)
        presenter.preparedata(context)

        textView.setText("Category")

        recyclerView.layoutManager = LinearLayoutManager(context)

        add_btn.setOnClickListener{
            listener?.gotoAddCategory()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener) {
            listener =  context
        }
    }
    override fun onDetach() {
        super.onDetach()
    }

    override fun showdata(data: List<Category>) {
        recyclerView.adapter = CategoryAdapter(data)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                CategoryFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

}
