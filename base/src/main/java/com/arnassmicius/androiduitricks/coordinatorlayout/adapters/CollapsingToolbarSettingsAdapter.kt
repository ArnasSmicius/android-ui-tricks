package com.arnassmicius.androiduitricks.coordinatorlayout.adapters

import com.arnassmicius.androiduitricks.R
import com.arnassmicius.androiduitricks.common.settingsadapter.BaseSettingsAdapter
import com.arnassmicius.androiduitricks.common.settingsadapter.entities.SwitchListItem
import com.arnassmicius.androiduitricks.common.settingsadapter.entities.TitleListItem

interface CollapsingToolbarSettingsAdapterDelegate {
    fun onSnapClicked(state: Boolean)
    fun onActionBarClicked(state: Boolean)
}

class CollapsingToolbarSettingsAdapter(
        private val delegate: CollapsingToolbarSettingsAdapterDelegate
) : BaseSettingsAdapter(actions) {

    private companion object {
        const val SNAP_ACTION = 1
        const val ACTION_BAR_ACTION = 2

        val actions = listOf(
                TitleListItem(
                        R.string.collapsing_toolbar_setting_title
                ),
                SwitchListItem(
                        SNAP_ACTION,
                        R.string.collapsing_toolbar_setting_snap_action_title,
                        R.string.collapsing_toolbar_setting_snap_action_description,
                        R.drawable.ic_magnet,
                        false
                ),
                SwitchListItem(
                        ACTION_BAR_ACTION,
                        R.string.collapsing_toolbar_setting_fab_action_title,
                        R.string.collapsing_toolbar_setting_fab_action_description,
                        R.drawable.ic_fab,
                        true
                ))
    }

    override fun onClick(itemId: Int?, state: Boolean?) {
        when (itemId) {
            SNAP_ACTION -> state?.let { delegate.onSnapClicked(it) }
            ACTION_BAR_ACTION -> state?.let { delegate.onActionBarClicked(it) }
        }
    }

    fun isSnapEnabled(): Boolean? {
        val snapAction = actions.findLast {
            it is SwitchListItem && it.itemId == SNAP_ACTION
        }
        return (snapAction as SwitchListItem).isEnabled
    }

    fun isActionBarEnabled(): Boolean {
        val actionBarAction = actions.findLast {
            it is SwitchListItem && it.itemId == ACTION_BAR_ACTION
        }
        return (actionBarAction as SwitchListItem).isEnabled
    }
}