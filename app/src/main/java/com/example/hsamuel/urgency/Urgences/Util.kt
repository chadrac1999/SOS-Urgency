package com.example.hsamuel.urgency.Urgences


import android.app.Fragment
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by hsamuel on 13/11/18.
 */
fun AppCompatActivity.replaceFragmenty(fragment: Fragment,
                                       allowStateLoss: Boolean = false,
                                       @IdRes containerViewId: Int) {
    val ft = fragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}