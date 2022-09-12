package com.moashrafff.nectar

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.moashrafff.nectar.databinding.ActivityMainBinding
import com.moashrafff.nectar.views.pages.a_Intro.SplashFragment
import com.moashrafff.nectar.views.pages.c_Home.HomeFragment
import com.moashrafff.nectar.views.pages.e_category.CategoryFragment
import com.moashrafff.nectar.views.pages.g_favorite.FavoriteFragment
import com.moashrafff.nectar.views.pages.h_cart.CartFragment
import com.moashrafff.nectar.views.pages.j_profile.ProfileFragment

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        showFragment(SplashFragment())
        binding.bottomNavView.setOnItemSelectedListener(this)

    }


    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.shopFragment -> showFragment(HomeFragment())
            R.id.exploreFragment -> showFragment(CategoryFragment())
            R.id.cartFragment -> showFragment(CartFragment())
            R.id.favoriteFragment -> showFragment(FavoriteFragment())
            else -> {
                showFragment(ProfileFragment())
            }
        }
        return true
    }
}