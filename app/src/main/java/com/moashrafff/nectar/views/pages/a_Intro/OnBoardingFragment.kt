package com.moashrafff.nectar.views.pages.a_Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentOnBoardingBinding
import com.moashrafff.nectar.views.pages.c_Home.HomeFragment
import com.moashrafff.nectar.views.pages.d_explore.ProductDetailsFragment


class OnBoardingFragment : Fragment() {

    private val binding by lazy { FragmentOnBoardingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.getStartedBtn.setOnClickListener(View.OnClickListener {
            showFragment()
        })


    }

    private fun showFragment (){
        Navigation.findNavController(binding.root).navigate(R.id.action_onBoardingFragment_to_welcomeFragment)
    }


}