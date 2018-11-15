package com.example.hsamuel.urgency.urgences


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hsamuel.urgency.R

class UrgencesType: Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_urgences_type, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = ItemAdapter(urgencyList)

        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                Toast.makeText(activity, "Click", Toast.LENGTH_SHORT).show()
            }
        })

        return v
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemData()


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
