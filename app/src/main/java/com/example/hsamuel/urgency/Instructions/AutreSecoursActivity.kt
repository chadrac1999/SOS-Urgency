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

class AutreSecoursActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_autre_secours, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recycler5) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = SecondItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                when(position){
                    0 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.brulure_title, "Etape1", R.string.brulure_desc, R.drawable.brulure_etap1))
                        showDialog(mal)
                    }
                    1 -> {
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.noya_etap1_title, "Etape1", R.string.noya_etap1_desc, R.drawable.noyade_etap1))
                        mal.add(PagerModel("2", R.string.noya_etap2_title, "Etape2", R.string.noya_etap2_desc, R.drawable.noyade_etap3))
                        showDialog(mal)
                    }
                    2 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.accouch1_title, "Etape1", R.string.accouch1_desc, R.drawable.accouch1))
                        mal.add(PagerModel("2", R.string.accouch2_title, "Etape2", R.string.accouch2_desc, R.drawable.accouch2))
                        showDialog(mal)
                    }
                    3 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.mor_anim1_title, "Etape1", R.string.mor_anim1_desc, R.drawable.morsur1))
                        mal.add(PagerModel("2", R.string.mor_anim2_title, "Etape2", R.string.mor_anim2_desc, R.drawable.morsur2))
                        mal.add(PagerModel("3", R.string.mor_anim3_title, "Etape2", R.string.mor_anim3_desc, R.drawable.morsur3))
                        showDialog(mal)
                    }
                    4 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.fracture1_title, "Etape1", R.string.fracture1_desc, R.drawable.fracture1))
                        mal.add(PagerModel("2", R.string.fracture2_title, "Etape2", R.string.fracture2_desc, R.drawable.fracture2))
                        showDialog(mal)
                    }
                    5 ->{
                        val mal = ArrayList<PagerModel>()
                        mal.add(PagerModel("1", R.string.intox_medi1_title, "Etape1", R.string.intox_medi1_desc, R.drawable.intox_medi1))
                        mal.add(PagerModel("2", R.string.intox_medi2_title, "Etape2", R.string.intox_medi2_desc, R.drawable.intox_medi2))
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
        var urgenceItem = Model("1","Brûlure", R.drawable.brulure)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Noyade", R.drawable.noyade)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Accouchement inopiné", R.drawable.accouch_inopi)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "Morsures et piqûres", R.drawable.morsur_anim)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("5", "Intoxication médicamenteuse", R.drawable.intoxic_medica)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("6", "Fractures", R.drawable.fracture)
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
