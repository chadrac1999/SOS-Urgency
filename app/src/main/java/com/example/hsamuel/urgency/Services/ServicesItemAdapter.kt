package com.example.hsamuel.urgency.Services

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hsamuel.urgency.R

/**
 * Created by hsamuel on 07/11/18.
 */
class ServicesItemAdapter(private val sItemmodel: ArrayList<DataModel>) : RecyclerView.Adapter<ServicesItemAdapter.sViewHolder>() {


    override fun onBindViewHolder(holder: sViewHolder, position: Int) {
        val item = sItemmodel[position]
        holder.bindItem(item)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : sViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_services, parent, false)
        return sViewHolder(v)
    }

    override fun getItemCount(): Int = sItemmodel.size

    class sViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        val txtTitle: TextView = v.findViewById(R.id.s_name)
        val txtNum: TextView = v.findViewById(R.id.s_num)

        fun bindItem(model: DataModel) {
            txtTitle.text = model.sName
            txtNum.text = model.sNumber
        }


        override fun onClick(v: View) {

        }
    }
}