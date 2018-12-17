package com.example.hsamuel.urgency.urgences

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.hsamuel.urgency.PagerModel
import com.example.hsamuel.urgency.R
import java.util.ArrayList


class UrgenceDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urgence_details)

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

    }


}