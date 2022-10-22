package com.moashrafff.nectar.views.pages.b_Account.b_login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.moashrafff.nectar.MainActivity
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUup.setOnClickListener(View.OnClickListener {
            showFragment()
        })

        binding.proceed.setOnClickListener(View.OnClickListener {
            moveToNewActivity()
        })

    }


    private fun showFragment (){
        Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    private fun moveToNewActivity() {
        val i = Intent(activity, MainActivity::class.java)
        startActivity(i)
        activity?.finish()
    }


}