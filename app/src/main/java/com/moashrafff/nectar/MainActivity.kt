package com.moashrafff.nectar

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.moashrafff.nectar.databinding.ActivityMainBinding
import com.moashrafff.nectar.views.pages.a_Intro.SplashFragment
import com.moashrafff.nectar.views.pages.c_Home.HomeFragment
import com.moashrafff.nectar.views.pages.e_category.CategoryFragment
import com.moashrafff.nectar.views.pages.g_favorite.FavoriteFragment
import com.moashrafff.nectar.views.pages.h_cart.CartFragment
import com.moashrafff.nectar.views.pages.j_profile.ProfileFragment
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

        navigate()


    }


//    private fun showFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, fragment)
//            .commit()
//    }

    private fun navigate(){
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