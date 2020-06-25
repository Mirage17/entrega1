package com.davidgrajales.mitswisser

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
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

                tv_show.text = "Faltan campos por llenar. Por favor verifique la información."

            } else {

                if (pass == pass2) {
                    tv_show.text = "Su nombre es: $nombre \n " +
                            "Su célular es: $celular \n" +
                            "Su correo electrónico es: $email \n" +
                            "Su fecha de nacimiento es: $fecha \n" +
                            "su contraseña es $pass"
                } else {
                    tv_show.text =
                        "las contraseñas no son iguales. Por favor verifique la información"
                }


            }

            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}