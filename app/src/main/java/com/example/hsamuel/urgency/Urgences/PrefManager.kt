package com.example.hsamuel.urgency.Urgences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.example.hsamuel.urgency.R

/**
 * Created by hsamuel on 04/11/18.
 */
class PrefManager {
    lateinit var con: Context
    lateinit var pref: SharedPreferences

    constructor(con: Context){
        this.con = con
        getSP()
    }
    private fun getSP(){
        pref= con.getSharedPreferences(con.getString(R.string.pref_name), Context.MODE_PRIVATE)
    }
    fun writeSP(){
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(con.getString(R.string.prev_key), "NEXT")
        editor.commit()
    }

    fun checkPreferences(): Boolean{
        var status: Boolean = false
        if(pref.getString(con.getString(R.string.prev_key), "").equals("")){
            status = false
        }
        else{
            status = true
        }
        return status
    }

    fun clearPreferences(){
        pref.edit().clear().commit()
        con.startActivity(Intent(con, MenuActivity::class.java))
        (con as MenuActivity).finish()

    }
}