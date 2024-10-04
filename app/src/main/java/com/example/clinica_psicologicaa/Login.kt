package com.example.clinica_psicologicaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.clinica_psicologicaa.ui.dashboard.DashboardFragment
import com.example.clinica_psicologicaa.ui.dashboard.DashboardViewModel
import java.sql.CallableStatement
import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

class Login : AppCompatActivity() {

    private var conexionSQL = ConexionSQL()
    private lateinit var Username: EditText
    private lateinit var Password: EditText
    private lateinit var btnIniciarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Username = findViewById(R.id.Usuario)
        Password = findViewById(R.id.Contraseña)

        val btnTextRegister = findViewById<TextView>(R.id.btnRegistrar)

        btnTextRegister.setOnClickListener {
            val intent: Intent = Intent(this, Registrarse2::class.java)
            startActivity(intent)
        }

        val btnTextRecordar = findViewById<TextView>(R.id.btnRecordarPassword)

        btnTextRecordar.setOnClickListener {
            val intent: Intent = Intent(this, RecordarPassword::class.java)
            startActivity(intent)

        }

        val btnIniciarSesion: ImageButton = findViewById(R.id.btnIniciarSesion)
        btnIniciarSesion.setOnClickListener {

            val conexionSQL = ConexionSQL().dbConn()
            val procedureCall = "{call PDLogear(?, ?, ?, ?)}"

            val username = Username.text.toString() // Obtén el nombre de usuario ingresado
            val password = Password.text.toString()

            try {
                val callableStatement: CallableStatement = conexionSQL?.prepareCall(procedureCall) !!

                callableStatement.setString(1, username)
                callableStatement.setString(2, password)
                callableStatement.registerOutParameter(3, Types.INTEGER)
                callableStatement.registerOutParameter(4, Types.INTEGER)

                callableStatement.execute()

                val abrirVentana = callableStatement.getInt(3)
                val acceso = callableStatement.getInt(4)

                if (acceso == 1) {
                    Toast.makeText(this, "Inicio de sesión exitosa", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@Login, docsapoyo::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }
                callableStatement.close()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                conexionSQL?.close()
            }

        }
    }
}

