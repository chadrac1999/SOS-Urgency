package com.example.hsamuel.urgency.urgences


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.ArrayList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager
import com.example.hsamuel.urgency.Instructions.*
import com.example.hsamuel.urgency.PagerModel
import com.example.hsamuel.urgency.R
import com.example.hsamuel.urgency.TestPagerAdapter
import com.example.hsamuel.urgency.services.ServicesActivity
import com.viewpagerindicator.CirclePageIndicator

class UrgencesType: Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()

    //Declaration of variables for dialogue to define actions in emergencies
    //lateinit var myDialog: Dialog
    //lateinit var con: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_urgences_type, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = ItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                when (position){
                    0 -> {
                        val fragment: Fragment = GesturesActivity()
                    displaySelectedFragment(fragment)
                    }
                    1 -> {
                        val fragment: Fragment = EtouffementActivity()
                        displaySelectedFragment(fragment)
                    }
                    2 -> {
                        val fragment: Fragment = MalaiseActivity()
                        displaySelectedFragment(fragment)
                    }
                    3 -> {
                        val fragment: Fragment = SaignementActivity()
                        displaySelectedFragment(fragment)
                    }
                    4 -> {
                        val fragment: Fragment = AutreSecoursActivity()
                        displaySelectedFragment(fragment)
                    }
                }
            }
        })

        return v

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemData()

    }

    fun itemData(){
        var urgenceItem = Model("1","Accidents", R.drawable.accidents)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Etouffements", R.drawable.etouffement)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Malaises", R.drawable.malaise)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "Saignements", R.drawable.saignement)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("5", "Autres secours", R.drawable.autre_secours)
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

    private fun displaySelectedFragment(fragment: Fragment){
        val supportFragmentManager = fragmentManager
        val fragmentTransaction = supportFragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

}
