package com.arnassmicius.androiduitricks.instant.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arnassmicius.androiduitricks.instant.R
import com.arnassmicius.androiduitricks.instant.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContainer, MainFragment.newInstance())
                    .commit()
        }
    }
}
