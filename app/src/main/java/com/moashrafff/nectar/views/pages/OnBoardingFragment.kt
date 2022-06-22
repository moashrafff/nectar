package com.moashrafff.nectar.views.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentOnBoardingBinding


class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.getStartedBtn?.setOnClickListener(View.OnClickListener {

            showFragment(ProductDetailsFragment())

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