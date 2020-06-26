package com.davidgrajales.mitswisser

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email=intent?.getStringExtra("correoUsuario")

        Toast.makeText(applicationContext,email, Toast.LENGTH_SHORT).show()
        tv_email2.text=email
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_logout, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       if (item.itemId == R.id.mi_logout) {
            Log.d("Menu", "Login")

             val intent: Intent=Intent(this,Login::class.java)
           startActivity(intent)


        }
        return super.onOptionsItemSelected(item)

    }

}