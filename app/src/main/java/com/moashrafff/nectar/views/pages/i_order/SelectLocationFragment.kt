package com.moashrafff.nectar.views.pages.i_order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentNumberVerificationBinding
import com.moashrafff.nectar.databinding.FragmentSelectLocationBinding

class SelectLocationFragment : Fragment() {


    private val binding by lazy { FragmentSelectLocationBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.selectLocationSubmitBtn.setOnClickListener(View.OnClickListener {
            showFragment()
        })

        binding.locationToolBar.backBtn.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        })
    }

    private fun showFragment (){
        Navigation.findNavController(binding.root).navigate(R.id.action_selectLocationFragment_to_loginFragment)
    }


}