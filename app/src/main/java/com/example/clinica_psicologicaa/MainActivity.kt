package com.example.clinica_psicologicaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.ui.AppBarConfiguration
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showGif()

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.calendarioView,R.id.navigation_dashboard,R.id.navigation_home,R.id.navigation_notifications))
    }
    fun showGif(){
        val SPLASH_DELAY: Long = 12000 // Duración del Splash Screen en milisegundos (en este caso, 3 segundos)

        val imageViewSplash: ImageView = findViewById(R.id.splashscreen) // Declarar e inicializar imageViewSplash

        Glide.with(this)
            .asGif()
            .load(R.drawable.splashscreem)
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .into(imageViewSplash)

        Handler().postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}
