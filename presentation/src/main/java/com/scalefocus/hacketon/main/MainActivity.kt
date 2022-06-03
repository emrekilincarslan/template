package com.scalefocus.hacketon.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.scalefocus.hacketon.R
import com.scalefocus.hacketon.databinding.ActivityMainBinding
import com.scalefocus.presentation.ktx.setupWithNavController
import com.scalefocus.presentation.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    private var currentNavController: NavController? = null

    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showStatusBar()
        binding.bottomNavigation.visibility = View.VISIBLE
        binding.mainAppBar.visibility = View.VISIBLE
        setSupportActionBar(binding.toolbar)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        binding.viewModel = viewModel

        binding.progressBar.visibility = viewModel.progressDialogVisibility
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = binding.bottomNavigation

        val navGraphIds = listOf(
            R.navigation.title1_graph,
            R.navigation.title2_graph
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_fragments_container,
            intent = intent
        )

        controller.observe(this) { navController ->
            setupActionBarWithNavController(navController)
            currentNavController = navController
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.navigateUp() ?: false
    }

    private fun showStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, binding.mainAppBar).isAppearanceLightStatusBars =
            true
    }

}