package com.arnassmicius.androiduitricks.extensions

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.annotation.StringRes

fun TextView.setTextResIdAndVisibility(@StringRes resId: Int?) {
    if (resId == null) {
        this.visibility = GONE
    } else {
        this.setText(resId)
        this.visibility = VISIBLE
    }
}