package com.davidgrajales.mitswisser

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(1500)

        setTheme(R.style.AppTheme)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logUSer = intent?.getStringExtra("nombreUsuario")
        val logPhone = intent?.getStringExtra("celularUsuario")
        val passemail=intent?.getStringExtra("correoUsuario")

        b_logEnter.setOnClickListener {

            //Toast.makeText(applicationContext,"$logUSer, $logPhone, ${et_LogUser.text.toString()} ${et_logPhone.text.toString()}", Toast.LENGTH_SHORT).show()

            if (logUSer == et_LogUser.text.toString() && logPhone == et_logPhone.text.toString()) {
                //Toast.makeText(applicationContext, "todo perfecto", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("correoUsuario",passemail)
                et_LogUser?.text?.clear()
                et_logPhone?.text?.clear()
                startActivity(intent)



            } else {
                Toast.makeText(applicationContext, "Los datos suministrados no coinciden", Toast.LENGTH_SHORT).show()
            }

        }

        b_log2Register.setOnClickListener {

                val intent: Intent = Intent(this, Registro::class.java)
                startActivity(intent)

            }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1234 && resultCode==Activity.RESULT_OK){

        }
    }
}