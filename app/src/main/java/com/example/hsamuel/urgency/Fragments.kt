package com.example.hsamuel.urgency

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hsamuel.urgency.R


/**
 * Created by hsamuel on 15/11/18.
 */
class Fragments : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v= inflater.inflate(R.layout.fragment_list, container, false)
        return v
    }

    /*fun showDialog() {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val pagerArr = ArrayList<PagerModel>()
        pagerArr.add(PagerModel("1", R.string.etap1_title, "Etape1", R.string.etap1_desc, R.drawable.acc_etap1))
        pagerArr.add(PagerModel("2", R.string.etap2_title, "Etape2", R.string.etap2_desc, R.drawable.acc_etap2))
        pagerArr.add(PagerModel("3", R.string.etap3_title, "Etape3", R.string.etap3_desc, R.drawable.acc_etap3))
        pagerArr.add(PagerModel("4", R.string.etap4_title, "Etape4", R.string.etap4_desc, R.drawable.acc_etap3))
        pagerArr.add(PagerModel("3", R.string.etap5_title, "Etape5", R.string.etap5_desc, R.drawable.acc_etap5))

        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

        dialog.window.setLayout(650, 1100)
    }

        fun showDialog1() {

            val dialog = Dialog(activity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_onboarding)

            val pagerArr = ArrayList<PagerModel>()

            val adapter = TestPagerAdapter(activity, pagerArr)

            val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

            pager.adapter = adapter

            dialog.show()

            dialog.window.setLayout(600, 900)
    }

    fun showDialog2() {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val pagerArr = ArrayList<PagerModel>()

        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

        dialog.window.setLayout(600, 900)
    }

    fun showDialog3() {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val pagerArr = ArrayList<PagerModel>()
        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

        dialog.window.setLayout(600, 900)
    }

    fun showDialog4() {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_onboarding)

        val pagerArr = ArrayList<PagerModel>()

        val adapter = TestPagerAdapter(activity, pagerArr)

        val pager = dialog.findViewById<View>(R.id.pager) as AutoScrollViewPager

        pager.adapter = adapter

        dialog.show()

        dialog.window.setLayout(600, 900)

    }*/

}