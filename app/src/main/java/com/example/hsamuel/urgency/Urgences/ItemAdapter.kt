package com.example.hsamuel.urgency.Urgences

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hsamuel.urgency.R

/**
 * Created by hsamuel on 31/10/18.
 */
class ItemAdapter(private val itemmodel: ArrayList<Model>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ugence_item, parent, false)
        return MyViewHolder(v)
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemmodel[position]
        holder.bindItem(item)

    }

    override fun getItemCount(): Int = itemmodel.size

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v){

        var txtTitle: TextView = v.findViewById(R.id.textView)
        val imageView: ImageView = v.findViewById(R.id.imageView)

        fun bindItem(model: Model) {
            txtTitle.text = model.title
            imageView.setImageResource(model.image_drawable)
        }


    }
}