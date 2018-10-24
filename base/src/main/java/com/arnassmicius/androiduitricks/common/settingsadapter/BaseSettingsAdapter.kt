package com.arnassmicius.androiduitricks.common.settingsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arnassmicius.androiduitricks.R
import com.arnassmicius.androiduitricks.common.settingsadapter.entities.SwitchListItem
import com.arnassmicius.androiduitricks.common.settingsadapter.entities.TitleListItem
import com.arnassmicius.androiduitricks.common.settingsadapter.viewholders.BaseViewHolder
import com.arnassmicius.androiduitricks.common.settingsadapter.viewholders.SwitchViewHolder
import com.arnassmicius.androiduitricks.common.settingsadapter.viewholders.TitleViewHolder

abstract class BaseSettingsAdapter(private val settingsList: List<Any>) : RecyclerView.Adapter<BaseViewHolder>() {

    private companion object {
        const val SWITCH = 1
        const val TITLE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            SWITCH -> {
                val view = layoutInflater.inflate(R.layout.settings_adapter_switch_list_item, parent, false)
                SwitchViewHolder(view)
            }
            TITLE -> {
                val view = layoutInflater.inflate(R.layout.settings_adapter_title_list_item, parent, false)
                TitleViewHolder(view)
            }
            else -> throw Exception("Unknown ViewHolder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        val setting = settingsList[position]
        when (viewType) {
            SWITCH -> {
                val switchSettings = setting as SwitchListItem
                val switchHolder = holder as SwitchViewHolder
                switchHolder.bind(switchSettings)
                switchHolder.switch.setOnCheckedChangeListener { _, state ->
                    switchSettings.isEnabled = state
                    onClick(setting.itemId, state)
                }
            }
            TITLE -> {
                val titleSettings = setting as TitleListItem
                val titleHolder = holder as TitleViewHolder
                titleHolder.setTitle(titleSettings.titleResId)
            }
        }
    }

    override fun getItemCount() = settingsList.size

    override fun getItemViewType(position: Int): Int {
        return when (settingsList[position]) {
            is TitleListItem -> TITLE
            is SwitchListItem -> SWITCH
            else -> throw Exception("Unknown list item")
        }
    }

    protected abstract fun onClick(itemId: Int?, state: Boolean? = null)
}