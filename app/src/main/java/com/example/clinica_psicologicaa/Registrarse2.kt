package com.example.clinica_psicologicaa
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Date

class Registrarse2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)


        lateinit var txtNombre : EditText
        lateinit var txtApellidos : EditText
        lateinit var txtNacimiento : EditText
        lateinit var txtIdClinica : EditText
        lateinit var txtContraseña : EditText
        lateinit var txtCorreo : EditText
        lateinit var txtUsuario : EditText
        lateinit var btnCrearCuenta: ImageButton

        val btnTextOiniciarsesion = findViewById<TextView>(R.id.btnOiniciarsesion)
        btnTextOiniciarsesion.setOnClickListener {
            val intent: Intent = Intent(this, Login::class.java)

            startActivity(intent)
        }

        txtNombre = findViewById(R.id.txtNombre)
        txtApellidos = findViewById(R.id.txtApellidos)
        txtNacimiento = findViewById(R.id.txtNacimiento)
        txtIdClinica = findViewById(R.id.txtIdClinica)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContraseña = findViewById(R.id.txtContraseña)
        txtCorreo = findViewById(R.id.txtCorreo)

        btnCrearCuenta = findViewById(R.id.btnCrearCuenta)
        btnCrearCuenta.setOnClickListener {
            print("boton funciona")

            val Nombres = txtNombre.text.toString()
            val Apellidos = txtApellidos.text.toString()
            val FechaNacimiento = txtNacimiento.text.toString()
            val IdClinica = txtIdClinica.text.toString()
            val usuarios = txtUsuario.text.toString()
            val password = txtContraseña.text.toString()
            val Correo = txtCorreo.text.toString()

            try {
                val addPersona:PreparedStatement = ConexionSQL().dbConn()?.prepareStatement("EXEC PDRegistrarpaciente ?,?,?,?,?,?,?" ) !!

                addPersona.setString(1, Nombres)
                addPersona.setString(2, Apellidos)
                addPersona.setDate(3, Date.valueOf(FechaNacimiento))
                addPersona.setString(4, IdClinica)
                addPersona.setString(5, usuarios)
                addPersona.setString(6, password)
                addPersona.setString(7, Correo)

                addPersona.executeUpdate()

                Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(this, Login::class.java)
                startActivity(intent)

            }catch (ex: SQLException){
                Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()

            }
        }

    }
}