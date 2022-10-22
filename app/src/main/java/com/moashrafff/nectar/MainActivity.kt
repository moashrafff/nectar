package com.moashrafff.nectar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moashrafff.nectar.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

//, NavigationBarView.OnItemSelectedListener

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        bottomNavigate()
        
    }


//    private fun showFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, fragment)
//            .commit()
//    }

    private fun bottomNavigate(){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavigationView.setupWithNavController(navHostFragment.navController)
    }


//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.shopFragment -> navigate(R.id.shopFragment)
//            R.id.exploreFragment -> navigate(R.id.exploreFragment2)
//            R.id.cartFragment -> navigate(R.id.homeFragment)
//            R.id.favoriteFragment -> navigate(R.id.homeFragment)
//            else -> {
//                navigate(R.id.homeFragment)
//            }
//        }
//        return true
//    }
}