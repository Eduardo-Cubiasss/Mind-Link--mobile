package com.example.clinica_psicologicaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RecordarPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordar_password)

        val btnRecuperar2 = findViewById<TextView>(R.id.btnRecuperar2)

        btnRecuperar2.setOnClickListener {
            val intent: Intent = Intent(this, recordar_password2::class.java)
            startActivity(intent)
        }

            val btnTextRegistrarseEnRecuperar1 = findViewById<TextView>(R.id.btnRegistrarteEnRecuperacion1)

            btnTextRegistrarseEnRecuperar1.setOnClickListener {
                val intent: Intent = Intent(this, Registrarse2::class.java)
                startActivity(intent)
            }
    }
}