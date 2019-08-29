package com.example.phone_book

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.phone_book.ui.contactList.ContactFragment
import com.example.phone_book.ui.favouriteList.FavouriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController: NavController = findNavController(R.id.fragment_container)
        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.fragment_container).navigateUp()

}
