package com.example.databasestudents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {


    lateinit var Navcontroller:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  navhostfragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as  NavHostFragment
        Navcontroller=navhostfragment.navController


    }
}