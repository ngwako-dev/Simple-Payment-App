package android.example.com.simplepaymentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.nav_host_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
       // return super.onSupportNavigateUp(R.id.m)
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

}