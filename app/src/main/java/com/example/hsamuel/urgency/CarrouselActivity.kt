package com.example.hsamuel.urgency

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.hsamuel.urgency.Urgences.MenuActivity
import com.example.hsamuel.urgency.Urgences.PrefManager

class CarrouselActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var vPager: ViewPager

    var layouts: IntArray = intArrayOf(R.layout.slide1, R.layout.slide2, R.layout.slide3)

    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView>

    lateinit var vAdapter: Adapter

    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (PrefManager(this).checkPreferences()){
            loadM()
        }

        if (Build.VERSION.SDK_INT >= 19){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        else{
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        setContentView(R.layout.activity_carrousel)
        vPager = findViewById(R.id.container)
        vAdapter = Adapter(layouts, this)
        vPager.adapter = vAdapter
        btnNext = findViewById<Button>(R.id.btn_next) as Button
        btnNext.setOnClickListener(this)
        dotsLayout = findViewById<LinearLayout>(R.id.dots) as LinearLayout
        createDots(0)
        vPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
               createDots(position)
                if (position == layouts.size - 1){
                    btnNext.text = getString(R.string.button_start)
                }
                else{
                    btnNext.text = getString(R.string.button_next)
                }
            }

        })
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_next -> {
                loadNext()
            }
        }
    }

    private fun loadNext() {
        val nextSlide: Int = vPager.currentItem + 1

        if (nextSlide < layouts.size ){
            vPager.currentItem = nextSlide
        }
        else{
            loadM()
            PrefManager(this).writeSP()
        }
    }


    fun createDots(position: Int){
        if (dotsLayout != null){
            dotsLayout.removeAllViews()
        }
        dots = Array(layouts.size, {i -> ImageView(this)})

        for (i in 0..layouts.size - 1){
            dots[i] = ImageView(this)
            if (i == position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots))
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dots))
            }
            val params: LinearLayout.LayoutParams =LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(4,0,4,0)
            dotsLayout.addView(dots[i], params)
        }
    }
    private fun loadM(){
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
    }
}
