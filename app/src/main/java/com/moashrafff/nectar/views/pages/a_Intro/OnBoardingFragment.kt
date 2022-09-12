package com.moashrafff.nectar.views.pages.a_Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentOnBoardingBinding
import com.moashrafff.nectar.views.pages.c_Home.HomeFragment
import com.moashrafff.nectar.views.pages.d_explore.ProductDetailsFragment


class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.findViewById<BottomNavigationView>(R.id.bottomNavView)?.visibility = View.GONE
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.getStartedBtn?.setOnClickListener(View.OnClickListener {

            showFragment(HomeFragment())

        })
    }

    private fun showFragment (fragment : Fragment){
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container,fragment)
            ?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}