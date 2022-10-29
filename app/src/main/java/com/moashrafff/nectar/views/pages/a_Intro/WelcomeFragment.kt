package com.moashrafff.nectar.views.pages.a_Intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentOnBoardingBinding
import com.moashrafff.nectar.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    private val binding by lazy { FragmentWelcomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.facebookBtn.setOnClickListener(View.OnClickListener {
            navigateToNumber()
        })

        binding.linearLayout.setOnClickListener(View.OnClickListener {
            navigateToNumber()
        })

        binding.welcomeFragmentTv.setOnClickListener(View.OnClickListener {
            navigateToNumber()
        })

    }



    private fun navigateToNumber (){
        Navigation.findNavController(binding.root).navigate(R.id.action_welcomeFragment_to_numberRegistrationFragment)
    }

}