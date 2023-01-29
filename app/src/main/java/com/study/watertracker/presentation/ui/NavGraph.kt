package com.study.watertracker.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.study.watertracker.presentation.home.HomeScreen
import com.study.watertracker.presentation.settings.SettingsScreen
import com.study.watertracker.presentation.stats.StatisticsScreen
import com.study.watertracker.presentation.ui.navigation.BottomNavigationItem

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = BottomNavigationItem.Home.route) {
        composable(BottomNavigationItem.Home.route) {
            HomeScreen(modifier)
        }
        composable(BottomNavigationItem.Statistics.route) {
            StatisticsScreen(modifier)
        }
        composable(BottomNavigationItem.Settings.route) {
            SettingsScreen(modifier)
        }
    }
}
