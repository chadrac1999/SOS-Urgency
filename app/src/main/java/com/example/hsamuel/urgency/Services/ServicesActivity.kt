package com.example.hsamuel.urgency.Services

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.hsamuel.urgency.R


class ServicesActivity : AppCompatActivity(){

    private lateinit var recyclerView1: RecyclerView

    private lateinit var viewAdapter1: RecyclerView.Adapter<*>

    private val servicesList = ArrayList<DataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        list1()

        viewAdapter1 = ServicesItemAdapter(servicesList)

        recyclerView1 = findViewById(R.id.s_recyclerView1)

        recyclerView1.layoutManager = LinearLayoutManager(this)
        recyclerView1.itemAnimator = DefaultItemAnimator()

        // specify an viewAdapter (see also next example)

        recyclerView1.adapter = viewAdapter1

        recyclerView1.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                callService()
            }
        })

    }


    fun callService(){

        var numero = findViewById<TextView>(R.id.s_num) as TextView

        var number = numero.text.toString()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            val callIntent =  Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + number)
            startActivity(callIntent)
        }
        else{
            Toast.makeText(this@ServicesActivity, "Autorisation requise", Toast.LENGTH_SHORT).show()
        }
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

