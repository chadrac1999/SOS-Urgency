package com.example.hsamuel.urgency.Instructions


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager
import com.example.hsamuel.urgency.PagerModel
import com.example.hsamuel.urgency.R
import com.example.hsamuel.urgency.TestPagerAdapter
import java.util.ArrayList
import com.example.hsamuel.urgency.urgences.Model

class MalaiseActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_malaise, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recycler3) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = SecondItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                when(position){
                    0 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.mal_card1_title, "Etape1", R.string.mal_card1_desc, R.drawable.malai_card1))
                        mal.add(PagerModel("2", R.string.mal_card2_title, "Etape2", R.string.mal_card2_desc, R.drawable.malai_card2))
                        mal.add(PagerModel("3", R.string.mal_card3_title, "Etape3", R.string.mal_card3_desc, R.drawable.malai_card3))
                        showDialog(mal)
                    }
                    1 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.overdose1_title, "Etape1", R.string.overdose1_desc, R.drawable.overdose1))
                        mal.add(PagerModel("2", R.string.overdose2_title, "Etape2", R.string.overdose2_desc, R.drawable.acc_etap5))
                        mal.add(PagerModel("3", R.string.overdose3_title, "Etape3", R.string.overdose3_desc, R.drawable.overdose3))
                        showDialog(mal)
                    }
                    2 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.convulsion1_title, "Etape1", R.string.convulsion1_desc, R.drawable.convulsion1))
                        mal.add(PagerModel("2", R.string.convulsion2_title, "Etape2", R.string.convulsion2_desc, R.drawable.acc_etap5))
                        showDialog(mal)
                    }
                    3 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.asthme1_title, "Etape1", R.string.asthme1_desc, R.drawable.asthme1))
                        mal.add(PagerModel("2", R.string.asthme2_title, "Etape2", R.string.asthme2_desc, R.drawable.asthme2))
                        showDialog(mal)
                    }
                }

            }
        })

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_gestures)
        itemData()

    }

    fun showDialog(pagerArr: ArrayList<PagerModel>) {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

        //dialog.window.setLayout(650, 1100)
    }

    fun itemData(){

        var urgenceItem = Model("1","Malaise Cardiaque", R.drawable.crise_cardiaque)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Overdose", R.drawable.overdose)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Convulsion", R.drawable.convulsions)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "Crise d'asthme", R.drawable.crise_asthm)
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
