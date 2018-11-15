package com.example.hsamuel.urgency.services

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.hsamuel.urgency.R


class ServicesActivity: Fragment(){

    private lateinit var recyclerView1: RecyclerView


    private val servicesList = ArrayList<DataModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_urgences_type, container, false)
        recyclerView1 = v.findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(activity)
        recyclerView1.itemAnimator = DefaultItemAnimator()
        recyclerView1.adapter = ServicesItemAdapter(servicesList)

        recyclerView1.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val numero = v.findViewById<TextView>(R.id.s_num) as TextView
                var number = numero.text.toString().trim()

                if (ContextCompat.checkSelfPermission(activity!!.applicationContext, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    val callIntent =  Intent(Intent.ACTION_DIAL)
                    callIntent.data = Uri.parse("tel:" + number)
                    startActivity(callIntent)
                }
                else{
                    Toast.makeText(activity, "Autorisation requise", Toast.LENGTH_SHORT).show()
                }
            }
        })

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list1()

    }


    fun list1(){
        var serviceItem = DataModel("Les Pompiers", "119")
        servicesList.add(serviceItem)

        serviceItem = DataModel("SAMU", "65290343")
        servicesList.add(serviceItem)

        serviceItem = DataModel("Autre", "000")
        servicesList.add(serviceItem)

        serviceItem = DataModel("Autre", "000")
        servicesList.add(serviceItem)

        serviceItem = DataModel("Autre", "000")
        servicesList.add(serviceItem)

        serviceItem = DataModel("Les Cocotiers", "65290343")
        servicesList.add(serviceItem)

        serviceItem = DataModel("Saint Anne", "65290343")
        servicesList.add(serviceItem)

        serviceItem = DataModel("St Luc", "65290343")
        servicesList.add(serviceItem)

        serviceItem = DataModel("La Gallilé", "65290343")
        servicesList.add(serviceItem)
    }


    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View?) {
                view?.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View?) {
                view?.setOnClickListener({
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                })
            }
        })
    }


}

