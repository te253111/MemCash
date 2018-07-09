package com.example.kanokk.memcash.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kanokk.memcash.R
import com.example.kanokk.memcash.model.Category
import kotlinx.android.synthetic.main.rows_category_items.view.*

class  CategoryAdapter(var items:List<Category>,var listener : Listener)  : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    interface Listener{
        fun gotoEditCategory(item :Category)
        fun gotoDelCategory(item :Category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rows_category_items, parent, false))
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.code_txt.setText(items.get(position).code)
        holder.category_txt.setText(items.get(position).name)
        holder.itemView.setOnClickListener{listener.gotoEditCategory(items.get(position))}
        holder.del_btn.setOnClickListener{listener.gotoDelCategory(items.get(position))}
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val category_txt = view.category_txt
        val code_txt = view.code_txt
        val del_btn = view.del_btn
    }
}