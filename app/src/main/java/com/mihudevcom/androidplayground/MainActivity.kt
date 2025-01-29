package com.mihudevcom.androidplayground

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        addBadgeToProfile(bottomNavigationView)
    }

    private fun addBadgeToProfile(bottomNavigationView: BottomNavigationView) {
        val badge: BadgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.nav_profile)
        badge.isVisible = true
        badge.number = 5
        badge.backgroundColor = getColor(R.color.primary)
        badge.badgeTextColor = getColor(R.color.onPrimary)
    }

    fun updateBadge(count:Int){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val badge = bottomNavigationView.getOrCreateBadge(R.id.nav_profile)
        if(count>0){
            badge.isVisible = true
            badge.number = count
        }else{
            bottomNavigationView.removeBadge(R.id.nav_profile)
        }
    }
}