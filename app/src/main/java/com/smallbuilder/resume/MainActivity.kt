package com.smallbuilder.resume

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val experienceButton = findViewById<Button>(R.id.experiencesButton)
        val callButton = findViewById<Button>(R.id.callButton)
        val emailButton = findViewById<Button>(R.id.emailButton)

        experienceButton.setOnClickListener {
            println("Hey you hit the button!")

            val moveToExperiencesActivity = Intent(applicationContext, ExperiencesActivity::class.java)
            startActivity(moveToExperiencesActivity)
        }

        callButton.setOnClickListener {
            println("You've just hit the call button")
            val phoneUri = Uri.parse("tel:0033669171426")
            val callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(callIntent)
        }

        emailButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "adrien.mechin@gmail.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Jolie CV :)")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "J'ai beaucoup apprécié ton CV...")
            startActivity(emailIntent)
        }
    }
}
