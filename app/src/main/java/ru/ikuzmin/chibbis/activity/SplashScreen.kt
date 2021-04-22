package ru.ikuzmin.chibbis.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.ikuzmin.chibbis.R
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.core.os.HandlerCompat.postDelayed


class SplashScreen : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        },SPLASH_DISPLAY_LENGTH)

    }
}