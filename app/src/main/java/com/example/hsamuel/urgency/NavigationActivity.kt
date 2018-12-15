package com.example.hsamuel.urgency

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.hsamuel.urgency.maps.MapsActivity
import com.example.hsamuel.urgency.services.ServicesActivity
import com.example.hsamuel.urgency.urgences.UrgencesType
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*



class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val fragment: Fragment = UrgencesType()
        displaySelectedFragment(fragment)
    }


    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings ->{
                val intent = Intent(this, AproposActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val fragment: Fragment
        when (item.itemId) {
            R.id.nav_gestes -> {
                fragment = UrgencesType()
                displaySelectedFragment(fragment)
            }
            R.id.nav_annuaire -> {
                fragment = ServicesActivity()
                displaySelectedFragment(fragment)

            }
            R.id.nav_map -> {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)


            }
            R.id.nav_share -> {

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_STREAM, "This is the text to send")
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent, "Partager avec"))
            }

            R.id.nav_about -> {
                val intent = Intent(this, AproposActivity::class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun displaySelectedFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment).addToBackStack(null).commit()
    }
}
