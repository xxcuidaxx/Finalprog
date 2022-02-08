package com.example.regisched

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

private lateinit var appBarConfig: AppBarConfiguration

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val navcontrol = findNavController(R.id.my_nav_host_fragment)
        appBarConfig = AppBarConfiguration(navcontrol .graph)
        setupActionBarWithNavController(navcontrol, appBarConfig)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navcontrol = findNavController(R.id.my_nav_host_fragment)
        return navcontrol.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

}