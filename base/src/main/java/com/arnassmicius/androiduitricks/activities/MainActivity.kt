package com.arnassmicius.androiduitricks.activities

import android.os.Bundle
import com.arnassmicius.androiduitricks.R
import com.arnassmicius.androiduitricks.fragments.MainFragment


class MainActivity : BaseActivity() {

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
