package com.example.hsamuel.urgency.Urgences

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hsamuel.urgency.R

/**
 * Created by hsamuel on 13/11/18.
 */
class List: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       return inflater.inflate(R.layout.ugence_item, container, false)
        /**recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ItemAdapter()
        return rootView*/


    }


}