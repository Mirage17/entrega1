package com.davidgrajales.mitswisser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(1500)

        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        b_log2Register.setOnClickListener {

            val intent: Intent=Intent(this,Registro::class.java)
            startActivity(intent)

        }
    }
}