package com.owoko.intent_calc_web


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var btshare: Button
    lateinit var btsms: Button
    lateinit var btcall: Button
    lateinit var btcamera: Button
    lateinit var btmpesa: Button
    lateinit var btdial: Button
    lateinit var btemail: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        btshare = findViewById(R.id.btn_share)
        btsms = findViewById(R.id.btn_sms)
        btcall = findViewById(R.id.btn_call)
        btcamera = findViewById(R.id.btn_camera)
        btmpesa = findViewById(R.id.btn_mpesa)
        btdial = findViewById(R.id.btn_dial)
        btemail = findViewById(R.id.btn_email)

        btshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }


        btsms.setOnClickListener {
            val uri= Uri.parse("smsto:0707337386")
            val intent=Intent (Intent.ACTION_SENDTO,uri)
            intent.putExtra("Good Afternoon","How are you doing today?")
            startActivity(intent)

        }

        btcall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }


        }



        btcamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(takePictureIntent, 1)

        }


        btmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        btdial.setOnClickListener {
            val phone = "+34666777888"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)

        }


        btemail.setOnClickListener {

            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))


        }
    }
}