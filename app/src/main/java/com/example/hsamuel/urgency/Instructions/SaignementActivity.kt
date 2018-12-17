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

class SaignementActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_saignement, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recycler4) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = SecondItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                when (position){
                    0 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.plai_simple_title, "Etape1", R.string.plai_simple_desc, R.drawable.plaie_simpl))
                        showDialog(mal)
                    }
                    1 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.plai_grav1_title, "Etape1", R.string.plai_grab1_desc, R.drawable.plai_grave1))
                        mal.add(PagerModel("2", R.string.plai_grav2_title, "Etape2", R.string.plai_grab2_desc, R.drawable.plaie_grave2))
                        mal.add(PagerModel("3", R.string.plai_grav3_title, "Etape3", R.string.plai_grab3_desc, R.drawable.plaie_grave2))
                        showDialog(mal)
                    }
                    2 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.saig_nez1_title, "Etape1", R.string.saig_nez_1_desc, R.drawable.convulsion1))
                        mal.add(PagerModel("2", R.string.saig_nez2_title, "Etape2", R.string.saig_nez_2_desc, R.drawable.acc_etap5))
                        showDialog(mal)
                    }
                    3 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.saig_simpl1_title, "Etape1", R.string.saig_simpl1_desc, R.drawable.saig_simpl1))
                        mal.add(PagerModel("2", R.string.saig_simpl2_title, "Etape2", R.string.saig_compl2_desc, R.drawable.saig_simpl4))
                        showDialog(mal)
                    }
                    4 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.saig_compl1_title, "Etape1", R.string.saig_compl1_desc, R.drawable.saig_compl1))
                        mal.add(PagerModel("2", R.string.saig_compl2_title, "Etape2", R.string.saig_compl2_desc, R.drawable.saig_compl2))
                        mal.add(PagerModel("2", R.string.saig_compl3_title, "Etape3", R.string.saig_compl3_desc, R.drawable.saig_compl3))
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
        var urgenceItem = Model("1","Plaie simple", R.drawable.plaie_simple)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Plaie grave", R.drawable.plaie_grave)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Saignement du nez", R.drawable.saigne_nez)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "Saignement simple", R.drawable.saignem_simpl)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "Saignement complexe", R.drawable.saigne_compl)
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
