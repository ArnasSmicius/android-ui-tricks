package com.arnassmicius.androiduitricks.common.settingsadapter.entities

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SwitchListItem(
        val itemId: Int,
        @StringRes val titleResId: Int,
        @StringRes val descriptionResId: Int,
        @DrawableRes val iconResId: Int,
        var isEnabled: Boolean
)