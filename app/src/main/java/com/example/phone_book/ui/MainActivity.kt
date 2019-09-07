package com.example.phone_book

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        //BottomAppBar
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_bar)
        // NavController
        val navController = findNavController(R.id.fragment_container)

        setupNavigation(bottomNavigationView, bottomAppBar, navController)

        fab.setOnClickListener{
            navController.navigate(R.id.addContactFragment)
        }

    }

    private fun setupNavigation(bottomNavigationView: BottomNavigationView, bottomAppBar: BottomAppBar, navController: NavController){
        //NavigationUI.setupWithNavController(bottomAppBar, navController)
        //NavigationUI.setupWithNavController(bottomNavigationView, navController)
        //Integrating BottomNavigationView and NavController
        bottomNavigationView.setupWithNavController(navController)
        //bottomAppBar.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            if(destination.id == R.id.detailsFragment || destination.id == R.id.addContactFragment
                || destination.id == R.id.editFragment) {
                bottom_bar.visibility = View.GONE
                fab.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE

            } else {
                bottomNavigationView.visibility = View.VISIBLE
                bottom_bar.visibility = View.VISIBLE
                fab.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.fragment_container).navigateUp()

}
