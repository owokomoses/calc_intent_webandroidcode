package com.owoko.intent_calc_web

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalcActivity : AppCompatActivity() {
    lateinit var tvanswer: TextView
    lateinit var edtfirstnum: EditText
    lateinit var edtsecondnum: EditText
    lateinit var buttonadd: Button
    lateinit var buttonminus: Button
    lateinit var buttondivide: Button
    lateinit var buttonmultiply: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        tvanswer = findViewById(R.id.textView)
        edtfirstnum = findViewById(R.id.edt_firstnumber)
        edtsecondnum = findViewById(R.id.edt_secondnumber)
        buttonadd = findViewById(R.id.btn_add)
        buttonminus = findViewById(R.id.btn_minus)
        buttondivide = findViewById(R.id.btn_divide)
        buttonmultiply = findViewById(R.id.btn_multiply)


        buttonadd.setOnClickListener {
            val firstnum = edtfirstnum.text.toString()
            val secondnum = edtsecondnum.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()) {
                tvanswer.text = "Please fill in all details"
            } else {
                var answer = firstnum.toDouble() + secondnum.toDouble()
                tvanswer.text = answer.toString()
            }

            

            buttonminus.setOnClickListener {
                val firstnum = edtfirstnum.text.toString()
                val secondnum = edtsecondnum.text.toString()
                if (firstnum.isEmpty() && secondnum.isEmpty()) {
                    tvanswer.text = "Please fill in all details"
                } else {
                    var answer = firstnum.toDouble() - secondnum.toDouble()
                    tvanswer.text = answer.toString()
                }

                buttondivide.setOnClickListener {
                    val firstnum = edtfirstnum.text.toString()
                    val secondnum = edtsecondnum.text.toString()
                    if (firstnum.isEmpty() && secondnum.isEmpty()) {
                        tvanswer.text = "Please fill in all details"
                    } else {
                        var answer = firstnum.toDouble() / secondnum.toDouble()
                        tvanswer.text = answer.toString()
                    }

                    buttonmultiply.setOnClickListener {
                        val firstnum = edtfirstnum.text.toString()
                        val secondnum = edtsecondnum.text.toString()
                        if (firstnum.isEmpty() && secondnum.isEmpty()) {
                            tvanswer.text = "Please fill in all details"
                        } else {
                            var answer = firstnum.toDouble() * secondnum.toDouble()
                            tvanswer.text = answer.toString()
                        }

                    }
                }
            }
        }
    }
}