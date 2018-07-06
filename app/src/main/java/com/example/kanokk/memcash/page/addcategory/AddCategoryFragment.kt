package com.example.kanokk.memcash.page.addcategory

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kanokk.memcash.R
import com.example.kanokk.memcash.page.category.CategoryFragment
import kotlinx.android.synthetic.main.fragment_add_category.*


class AddCategoryFragment : Fragment(),AddCategoryContract.View {

    var presenter = AddCategoryPresenter()

    var listener : Listener? = null

    interface Listener{
        fun gotoCategory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_category, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.preparedata()
        presenter.AddView(this)
        addcategory_btn.setOnClickListener{
            presenter.addcategory(codecategory_edt.text.toString(),addcategory_edt.text.toString(),context)
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

    override fun showmessage(mess: String) {
        Log.d("Data : ", mess)
        listener?.gotoCategory()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                AddCategoryFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
