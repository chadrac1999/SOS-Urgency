package com.example.hsamuel.urgency

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_apropos.*
import kotlinx.android.synthetic.main.app_bar_navigation.*

class AproposActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apropos)
        setSupportActionBar(toolbar)
        title = "A Propos"

        btnfollow.setOnClickListener {
            val pageUrl = "https://web.facebook.com/kodoratech/"
            val intentFollow = Intent(Intent.ACTION_VIEW, Uri.parse(pageUrl))
            startActivity(intentFollow)
        }
        sharetxt.setOnClickListener {
            val intentShare = Intent()
            intentShare.action = Intent.ACTION_SEND
            intentShare.putExtra(Intent.EXTRA_STREAM, "This is the text to send")
            intentShare.type = "text/plain"
            startActivity(Intent.createChooser(intentShare, "Partager avec"))

        }


    }

}
