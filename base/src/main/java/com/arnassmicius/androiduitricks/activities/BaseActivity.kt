package com.arnassmicius.androiduitricks.activities

import android.graphics.Color
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.arnassmicius.androiduitricks.R

abstract class BaseActivity : AppCompatActivity() {

    fun makeTransparentStatusBar(isTransparent: Boolean) {
        if (isTransparent) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }
    }

}