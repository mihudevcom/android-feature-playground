package com.mihudevcom.androidplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mihudevcom.androidplayground.viewmodel.BadgeViewModel

class MainActivity : AppCompatActivity() {

    private val badgeViewModel: BadgeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        badgeViewModel.badgeCount.observe(this@MainActivity) { count ->
            updateBadge(
                bottomNavigationView,
                count
            )
        }
    }


    private fun updateBadge(bottomNavigationView: BottomNavigationView, count: Int) {
        val badge = bottomNavigationView.getOrCreateBadge(R.id.nav_profile)
        if (count > 0) {
            badge.isVisible = true
            badge.clearNumber()
        } else {
            bottomNavigationView.removeBadge(R.id.nav_profile)
        }
    }
}