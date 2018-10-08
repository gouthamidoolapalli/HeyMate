package com.heymate.reckon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.heymate.reckon.ui.LaunchLoginActivity
import com.heymate.reckon.utils.CommonUtils

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DURATION = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            CommonUtils.startActivity(this, LaunchLoginActivity::class.java)
            finish()
        }, SPLASH_DURATION)
    }
}
