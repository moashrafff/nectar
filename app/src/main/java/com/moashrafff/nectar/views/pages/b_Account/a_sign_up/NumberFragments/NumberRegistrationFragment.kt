package com.moashrafff.nectar.views.pages.b_Account.a_sign_up.NumberFragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hbb20.CountryCodePicker

import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentNumberRegistrationBinding
import java.util.concurrent.TimeUnit


class NumberRegistrationFragment : Fragment() {

    private val binding by lazy { FragmentNumberRegistrationBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: NumberSharedViewModel
    private lateinit var phoneNumber : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registrationProgressBar.visibility = View.GONE

        auth = Firebase.auth

        viewModel = ViewModelProvider(requireActivity())[NumberSharedViewModel::class.java]





        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                Log.d("TAG", "onVerificationCompleted:$credential")

            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.w("TAG", "onVerificationFailed", e)
                
                Toast.makeText(requireContext(),e.toString(),Toast.LENGTH_LONG).show()

                if (e is FirebaseAuthInvalidCredentialsException) {
                    binding.registrationProgressBar.visibility = View.GONE
                }
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                binding.registrationProgressBar.visibility = View.GONE
                viewModel.sendMessage(verificationId)
                Log.e(TAG, "onCodeSentVerification is: $verificationId")
            }
        }




        binding.numberRegSubmitBtn.setOnClickListener(View.OnClickListener {
            binding.registrationProgressBar.visibility = View.VISIBLE
            phoneNumber = "+20".plus(binding.editTextCarrierNumber.text)

            viewModel.sendNumber(phoneNumber)

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(requireActivity()) // Activity (for callback binding)
                .setCallbacks(callbacks)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)
            showFragment()

        })

        binding.numberToolBar.backBtn.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        })

    }

    private fun showFragment() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_numberRegistrationFragment_to_numberVerificationFragment)
    }



}