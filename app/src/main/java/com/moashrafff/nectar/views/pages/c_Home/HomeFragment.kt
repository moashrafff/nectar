package com.moashrafff.nectar.views.pages.c_Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moashrafff.nectar.R



class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.findViewById<BottomNavigationView>(R.id.bottomNavView)?.visibility = View.VISIBLE
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}