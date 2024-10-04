package com.example.clinica_psicologicaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class recordar_password2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordar_password2)

        val btnYaRecordaste = findViewById<TextView>(R.id.btnYaRecordaste)

        btnYaRecordaste.setOnClickListener {
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

            val btnTextRegistrarseEnRecuperar2 = findViewById<TextView>(R.id.btnRegistrarteEnRecuperacion2)

            btnTextRegistrarseEnRecuperar2.setOnClickListener {
                val intent: Intent = Intent(this, Registrarse2::class.java)
                startActivity(intent)
            }
    }
}