package com.study.watertracker.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.study.watertracker.R

sealed class BottomNavigationItem(
    @StringRes var titleResId: Int,
    @DrawableRes var icon: Int,
    var route: String
) {
    object Home :
        BottomNavigationItem(R.string.menu_item_home, R.drawable.ic_baseline_home_24, "home")

    object Statistics : BottomNavigationItem(
        R.string.menu_item_statistics,
        R.drawable.ic_baseline_bar_chart_24,
        "statistics"
    )

    object Settings :
        BottomNavigationItem(
            R.string.menu_item_settings,
            R.drawable.ic_baseline_settings_24,
            "settings"
        )
}
