package com.example.phone_book

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()

    }

    private fun setupNavigation(){
        // BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        // NavController
        val navController: NavController = findNavController(R.id.fragment_container)
        // Integrating BottomNavigationView and NavController
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.fragment_container).navigateUp()

}
