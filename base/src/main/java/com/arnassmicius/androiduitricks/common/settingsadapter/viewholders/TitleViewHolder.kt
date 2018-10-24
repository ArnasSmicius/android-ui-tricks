package com.arnassmicius.androiduitricks.common.settingsadapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.arnassmicius.androiduitricks.extensions.setTextResIdAndVisibility
import kotlinx.android.synthetic.main.settings_adapter_title_list_item.view.*

class TitleViewHolder(itemView: View) : BaseViewHolder(itemView) {
    val title: TextView = itemView.titleText

    fun setTitle(@StringRes titleResId: Int?) {
        title.setTextResIdAndVisibility(titleResId)
    }
}