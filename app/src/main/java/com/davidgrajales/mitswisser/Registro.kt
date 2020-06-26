package com.davidgrajales.mitswisser

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*
import java.text.SimpleDateFormat

import java.util.*

class Registro : AppCompatActivity() {

    private lateinit var fecha: String
    private var cal = Calendar.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "dd-MM-yyyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_calendar.text = fecha

            }

        }



        ib_calendar.setOnClickListener {

            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()

        }

        b_save.setOnClickListener {

            var n = 0
            val nombre = et_nombre.text.toString()
            val celular = et_cel.text.toString()
            val email = et_email.text.toString()
            val fecha = tv_fecha.text.toString()
            val pass = et_pass.text.toString()
            val pass2 = et_pass2.text.toString()
            val lugar = tv_LugarDeNacimiento.text.toString()

            if (cb_ajedrez.isChecked || cb_apnea.isChecked || cb_judo.isChecked || cb_rugby.isChecked) {
                n = 1
            } else {
                n = 0
            }

            if (n == 0 || nombre.isEmpty() || celular.isEmpty() || email.isEmpty() || fecha.isEmpty() || pass.isEmpty() || pass2.isEmpty() || lugar.isEmpty()) {

                Toast.makeText(applicationContext,"Faltan campos por llenar",Toast.LENGTH_SHORT).show()

            } else {

                if(pass.length<=6){
                    Toast.makeText(applicationContext,"Su contraseña debe más de 6 caracteres", Toast.LENGTH_SHORT).show()

                }

                else{

                    if (pass == pass2) {
                        /*tv_show.text = "Su nombre es: $nombre \n " +
                                "Su célular es: $celular \n" +
                                "Su correo electrónico es: $email \n" +
                                "Su fecha de nacimiento es: $fecha \n" +
                                "su contraseña es $pass"*/
                        val name2pass=et_nombre.text.toString()
                        val cel2pass=et_pass.text.toString()
                        val email2pass=et_email.text.toString()
                        val intent=Intent(this,Login::class.java)

                        intent.putExtra("nombreUsuario",name2pass)
                        intent.putExtra("celularUsuario",cel2pass)


                        intent.putExtra("correoUsuario",email2pass)

                        setResult(Activity.RESULT_OK)

                        startActivity(intent)
                        finish()
                    }

                    else {
                        Toast.makeText(applicationContext,"Las contraseñas no son iguales", Toast.LENGTH_SHORT).show()
                    }


                }




            }


        }
    }



}