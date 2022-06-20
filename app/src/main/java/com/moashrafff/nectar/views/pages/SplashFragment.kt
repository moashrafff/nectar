package com.moashrafff.nectar.views.pages

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moashrafff.nectar.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(Runnable {
            showFragment(OnBoardingFragment())
        },3000)
    }

    private fun showFragment (fragment : Fragment){
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container,fragment)
            ?.commit()
    }

}