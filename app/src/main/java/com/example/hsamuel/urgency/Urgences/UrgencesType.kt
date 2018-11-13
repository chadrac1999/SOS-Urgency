package com.example.hsamuel.urgency.Urgences

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.hsamuel.urgency.R

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

        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                Toast.makeText(this@UrgencesType, "Click", Toast.LENGTH_SHORT).show()

            }
        })

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
