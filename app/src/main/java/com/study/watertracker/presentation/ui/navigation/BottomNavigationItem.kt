package com.study.watertracker.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.study.watertracker.R
import com.study.watertracker.ui.theme.Icons

sealed class BottomNavigationItem(
    @StringRes var titleResId: Int,
    @DrawableRes var icon: Int,
    var route: String
) {
    object Home :
        BottomNavigationItem(R.string.menu_item_home, Icons.HOME.iconRes, "home")

    object Statistics : BottomNavigationItem(
        R.string.menu_item_statistics,
        Icons.CHARTS.iconRes,
        "statistics"
    )

    object Settings :
        BottomNavigationItem(
            R.string.menu_item_settings,
            Icons.SETTINGS.iconRes,
            "settings"
        )
}
