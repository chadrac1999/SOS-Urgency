package com.example.hsamuel.urgency

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class UrgencesType : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urgences_type)

        itemData()

        viewAdapter = ItemAdapter(urgencyList)

        recyclerView = findViewById(R.id.recyclerView)

            // use a linear layout manager
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.itemAnimator = DefaultItemAnimator()

            // specify an viewAdapter (see also next example)
            recyclerView.adapter = viewAdapter


    }

    fun itemData(){
        var urgenceItem = Model("Accident de Circulation", R.drawable.respiratoire)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("Crise Cardiaque", R.drawable.crise_cardiaque)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("Etouffement", R.drawable.etouffement)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("Chute Accidentelle", R.drawable.chute_accident)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("Evanouissement", R.drawable.evanouissement)
        urgencyList.add(urgenceItem)
    }

}
