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
import android.widget.ImageButton
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager
import com.example.hsamuel.urgency.PagerModel
import com.example.hsamuel.urgency.R
import com.example.hsamuel.urgency.TestPagerAdapter
import java.util.ArrayList
import com.example.hsamuel.urgency.urgences.Model
import kotlinx.android.synthetic.main.dialog_onboarding.*

class EtouffementActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_etouffement, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recycler2) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = SecondItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                var v: View? = moins
                when(v!!.id){
                    R.id.plus -> {

                    }
                }
                when (position){
                    0 -> {
                        val etouf = ArrayList<PagerModel>()
                        etouf.add(PagerModel("1", R.string.etouf_adul1_title, "Etape1", R.string.etouf_adul1_desc, R.drawable.etoufadul_etap1))
                        etouf.add(PagerModel("2", R.string.etouf_adul2_title, "Etape2", R.string.etouf_adul2_desc, R.drawable.etoufadult_etap2))
                        etouf.add(PagerModel("3", R.string.etouf_adul3_title, "Etape3", R.string.etouf_adul3_desc, R.drawable.etoufadul_etap3))
                        etouf.add(PagerModel("4", R.string.etouf_adul4_title, "Etape4", R.string.etouf_adul4_desc, R.drawable.etoufadult_etap4))
                        showDialog(etouf)
                    }
                    1 -> {
                        val etouf = ArrayList<PagerModel>()
                        etouf.add(PagerModel("1", R.string.etouf_enf1_title, "Etape1", R.string.etouf_enf1_desc, R.drawable.etoufenfan_etap1))
                        etouf.add(PagerModel("2", R.string.etouf_enf2_title, "Etape2", R.string.etouf_enf2_desc, R.drawable.etoufenfan_etap2))
                        etouf.add(PagerModel("3", R.string.etouf_enf3_title, "Etape3", R.string.etouf_enf3_desc, R.drawable.etoufenfan_etap3))
                        etouf.add(PagerModel("2", R.string.etouf_enf4_title, "Etape4", R.string.etouf_enf4_desc, R.drawable.etoufenfan_etap4))
                        showDialog(etouf)
                    }
                    2 -> {
                        val etouf = ArrayList<PagerModel>()
                        etouf.add(PagerModel("1", R.string.etouf_nour_title, "Etape1", R.string.etouf_nour_desc, R.drawable.etoufnouris))
                        showDialog(etouf)
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

        fun essai(){
            val next: Int = pager.currentItem + 1
            if (next < pagerArr.size){
                pager.currentItem = next
            }
        }
        dialog.show()

        //dialog.window.setLayout(650, 1100)
    }


    fun itemData(){
        var urgenceItem = Model("1", "Etouffement d'adulte", R.drawable.etouf_adult)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Etouffement d'enfant", R.drawable.etouf_enfant)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Etouffement de nourrisson", R.drawable.etouf_nourris)
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
