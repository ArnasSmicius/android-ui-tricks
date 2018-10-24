package com.arnassmicius.androiduitricks.common.settingsadapter.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.StringRes
import com.arnassmicius.androiduitricks.common.settingsadapter.entities.SwitchListItem
import com.arnassmicius.androiduitricks.extensions.setTextResIdAndVisibility
import kotlinx.android.synthetic.main.settings_adapter_switch_list_item.view.*

class SwitchViewHolder(itemView: View) : BaseViewHolder(itemView) {
    val icon: ImageView = itemView.switchIcon
    val title: TextView = itemView.switchTitle
    val description: TextView = itemView.switchDescription
    val switch: Switch = itemView.switchButton

    init {
        itemView.setOnClickListener { switch.toggle() }
    }

    private fun setTitle(@StringRes titleResId: Int?) {
        title.setTextResIdAndVisibility(titleResId)
    }

    private fun setDescription(@StringRes descriptionResId: Int?) {
        description.setTextResIdAndVisibility(descriptionResId)
    }

    private fun setSwitch(isEnabled: Boolean) {
        switch.isChecked = isEnabled
    }

    fun bind(item: SwitchListItem) {
        icon.setImageResource(item.iconResId)
        setTitle(item.titleResId)
        setDescription(item.descriptionResId)
        setSwitch(item.isEnabled)
    }
}