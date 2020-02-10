package com.fury.flickerapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.widget.Toolbar
import com.fury.flickerapp.R
import com.fury.flickerapp.base.core.BaseActivity
import com.fury.flickerapp.databinding.ActivitySplashBinding

private const val SPLASH_TIME = 1500L
class SplashActivity : BaseActivity<ActivitySplashBinding>() {


    override val layoutResId: Int get() = R.layout.activity_splash

    override fun getToolBar(binding: ActivitySplashBinding): Toolbar? {return null}

    override fun onActivityReady(instance: Bundle?, binding: ActivitySplashBinding) {
        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }

}
