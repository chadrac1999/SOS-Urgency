package com.example.hsamuel.urgency.Instructions

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hsamuel.urgency.R
import com.example.hsamuel.urgency.urgences.ItemAdapter
import com.example.hsamuel.urgency.urgences.Model

/**
 * Created by chadrac on 12/9/18.
 */
class SecondItemAdapter(private val itemmodel: ArrayList<Model>): RecyclerView.Adapter<SecondItemAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.details_item, parent, false)
        return SecondItemAdapter.MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemmodel[position]
        holder.bindItem(item)

    }

    override fun getItemCount(): Int = itemmodel.size

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v){

        var txtTitle: TextView = v.findViewById(R.id.textView1)
        val imageView: ImageView = v.findViewById(R.id.imageView1)

        fun bindItem(model: Model) {
            txtTitle.text = model.title
            imageView.setImageResource(model.image_drawable)
        }


    }
}