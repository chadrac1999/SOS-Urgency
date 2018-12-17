package com.example.hsamuel.urgency.Instructions


import android.app.Dialog
import android.content.Context
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

class GesturesActivity : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private val urgencyList = ArrayList<Model>()

    lateinit var myDialog: Dialog
    lateinit var con: Context


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.activity_gestures, container, false)
        recyclerView = v.findViewById<RecyclerView>(R.id.recycler1) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = SecondItemAdapter(urgencyList)
        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, v: View) {
                when (position){
                    0 -> {
                        val accCircul = ArrayList<PagerModel>()
                        accCircul.add(PagerModel("1", R.string.etap1_title, "Etape1", R.string.etap1_desc, R.drawable.acc_etap1))
                        accCircul.add(PagerModel("2", R.string.etap2_title, "Etape2", R.string.etap2_desc, R.drawable.acc_etap2))
                        accCircul.add(PagerModel("3", R.string.etap3_title, "Etape3", R.string.etap3_desc, R.drawable.acc_etap3))
                        accCircul.add(PagerModel("4", R.string.etap4_title, "Etape4", R.string.etap4_desc, R.drawable.acc_circl_etap4))
                        accCircul.add(PagerModel("5", R.string.etap5_title, "Etape5", R.string.etap5_desc, R.drawable.acc_etap5))
                        showDialog(accCircul)
                    }
                    1 -> {
                        val accCircul = ArrayList<PagerModel>()
                        accCircul.add(PagerModel("1", R.string.accsp1_title, "Etape1", R.string.accsp1_desc, R.drawable.acc_spor_etap1))
                        accCircul.add(PagerModel("2", R.string.accsp2_title, "Etape2", R.string.accsp2_desc, R.drawable.acc_spor_etap2))
                        accCircul.add(PagerModel("3", R.string.accsp3_title, "Etape3", R.string.accsp3_desc, R.drawable.acc_spor_etap3))
                        accCircul.add(PagerModel("4", R.string.accsp4_title, "Etape4", R.string.accsp4_desc, R.drawable.acc_spor_etap4))
                        showDialog(accCircul)
                    }
                    2 -> {
                        val accCircul = ArrayList<PagerModel>()
                        accCircul.add(PagerModel("1", R.string.acccere1_title, "Etape1", R.string.acccere1_desc, R.drawable.acc_cereb_etap1))
                        accCircul.add(PagerModel("2", R.string.acccere2_title, "Etape2", R.string.acccere2_desc, R.drawable.acc_cereb_etap2))
                        accCircul.add(PagerModel("3", R.string.acccere3_title, "Etape3", R.string.acccere3_desc, R.drawable.acc_cereb_etap3))
                        showDialog(accCircul)
                    }
                    3 -> {
                        val accCircul = ArrayList<PagerModel>()
                        accCircul.add(PagerModel("1", R.string.avc1_title, "Etape1", R.string.avc1_desc, R.drawable.avc_enfant))
                        accCircul.add(PagerModel("2", R.string.avc2_title, "Etape2", R.string.avc2_desc, R.drawable.avcenfant2))
                        showDialog(accCircul)
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

    /*public void showDialog(View v){

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_onboarding);

        List<PagerModel> pagerArr = new ArrayList<>();
        TestPagerAdapter adapter = new TestPagerAdapter(this, pagerArr);

        AutoScrollViewPager pager = (AutoScrollViewPager) dialog.findViewById(R.id.pager);

        pager.setAdapter(adapter);

        CirclePageIndicator pageIndicator = (CirclePageIndicator) dialog.findViewById(R.id.page_indicator);
        pageIndicator.setViewPager(pager);
        pageIndicator.setCurrentItem(0);

        dialog.show();

    }*/


    fun showDialog(pagerArr: ArrayList<PagerModel>) {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

       // dialog.window.setLayout(700, 1200)
    }

    fun itemData(){
        var urgenceItem = Model("1","Accident de circulation", R.drawable.acci_circul)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("2", "Accident au sport", R.drawable.acci_sport)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("3", "Accident Cérébraux", R.drawable.acci_cerebraux)
        urgencyList.add(urgenceItem)

        urgenceItem = Model("4", "AVC chez les enfants", R.drawable.avc_enfant)
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
