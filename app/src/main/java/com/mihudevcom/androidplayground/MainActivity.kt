package com.mihudevcom.androidplayground

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            navController.navigate(R.id.nav_add_item)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_add_item) {
                animateFab(fab, false)
            } else {
                animateFab(fab, true)
            }
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

    private fun animateFab(fab: FloatingActionButton, show: Boolean) {
        if (show) {
            fab.animate().scaleX(1f).scaleY(1f).setDuration(200).start()
        } else {
            fab.animate().scaleX(0f).scaleY(0f).setDuration(200).start()
        }
    }
}