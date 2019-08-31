package com.example.phone_book

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        // NavController
        val navController: NavController = findNavController(R.id.fragment_container)

        setupNavigation(bottomNavigationView, navController)

        fab.setOnClickListener{
            navController.navigate(R.id.addContactFragment)
        }

    }

    private fun setupNavigation(bottomNavigationView: BottomNavigationView, navController: NavController){
        // Integrating BottomNavigationView and NavController
        bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if(destination.id == R.id.detailsFragment){
                bottom_bar.visibility = View.GONE
                fab.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE
            } else {
                bottom_bar.visibility = View.VISIBLE
                fab.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.fragment_container).navigateUp()

}
