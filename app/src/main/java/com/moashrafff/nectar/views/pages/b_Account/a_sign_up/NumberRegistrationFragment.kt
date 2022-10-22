package com.moashrafff.nectar.views.pages.b_Account.a_sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentNumberRegistrationBinding
import com.moashrafff.nectar.databinding.FragmentWelcomeBinding


class NumberRegistrationFragment : Fragment() {

    private val binding by lazy { FragmentNumberRegistrationBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.numberRegSubmitBtn.setOnClickListener(View.OnClickListener {
            showFragment()
        })

        binding.numberToolBar.backBtn.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        })

    }

    private fun showFragment (){
        Navigation.findNavController(binding.root).navigate(R.id.action_numberRegistrationFragment_to_numberVerificationFragment)
    }


}