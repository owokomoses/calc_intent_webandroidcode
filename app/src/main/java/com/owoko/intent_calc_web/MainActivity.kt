package com.owoko.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btn_calc)
        button2 = findViewById(R.id.btn_intent)
        button3 = findViewById(R.id.btn_web)


        button.setOnClickListener {
            val intent = Intent(this, CalcActivity::class.java)
             startActivity(intent)}

            button2.setOnClickListener {
                val intent= Intent(this, IntentActivity::class.java)
                startActivity(intent)}

                button3.setOnClickListener {
                    val intent = Intent(this, webActivity::class.java)
                    startActivity(intent)

                }



    }


}








