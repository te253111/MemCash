package com.example.kanokk.memcash.page.editcategory

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kanokk.memcash.R
import com.example.kanokk.memcash.model.Category
import kotlinx.android.synthetic.main.fragment_edit_category.*


class EditCategoryFragment : Fragment(),EditCategoryContract.View {

    var presenter = EditCategoryPresenter()

    var listener : Listener? = null

    interface Listener{
        fun gotoCategoryfromedit()
    }

    private val ARG_PARAM1 = "param1"
    private var param1: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_edit_category, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.preparedata()
        presenter.AddView(this)

        editcodecategory_edt.setText(param1?.code)
        editcategory_edt.setText(param1?.name)

        editcategory_btn.setOnClickListener{
            presenter.editcategory(param1?.uid!!,editcodecategory_edt.text.toString(),editcategory_edt.text.toString(),context)
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
        listener?.gotoCategoryfromedit()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Category) =
                EditCategoryFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(ARG_PARAM1, param1)
                    }
                }
    }
}
