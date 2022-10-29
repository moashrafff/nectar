package com.moashrafff.nectar.views.pages.b_Account.a_sign_up.NumberFragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.moashrafff.nectar.MainActivity
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.FragmentNumberVerificationBinding
import java.util.concurrent.TimeUnit


class NumberVerificationFragment : Fragment() {



    private val binding by lazy { FragmentNumberVerificationBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: NumberSharedViewModel
    private lateinit var verificationId : String
    private lateinit var verificationCode : String
    private lateinit var mobileNumber : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        auth = Firebase.auth
        viewModel = ViewModelProvider(requireActivity())[NumberSharedViewModel::class.java]



        viewModel.message.observe(viewLifecycleOwner, Observer {
            verificationId = it
        })




        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                Log.d("TAG", "onVerificationCompleted:$credential")

            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.w("TAG", "onVerificationFailed", e)

            }

            override fun onCodeSent(
                newVerificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                verificationId = newVerificationId
                Toast.makeText(requireContext(),"Verification Code Sent" , Toast.LENGTH_LONG).show()
            }
        }








        binding.numberVerSubmitBtn.setOnClickListener(View.OnClickListener {

            verificationCode = binding.numVerCodeEt.text.toString()

            if (verificationCode.isEmpty()){
                Toast.makeText(requireContext(),"Please Enter Valid Code",Toast.LENGTH_LONG).show()
            }

            if (verificationId.isNotEmpty()) {

                binding.verificationProgressBar.visibility = View.VISIBLE

                val phoneAuthCredential =
                    PhoneAuthProvider.getCredential(verificationId, verificationCode)
                FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                    .addOnCompleteListener(OnCompleteListener {
                        binding.verificationProgressBar.visibility = View.GONE
                        binding.numberVerSubmitBtn.visibility = View.VISIBLE

                        if (it.isSuccessful) {
                            val intent = Intent(activity, MainActivity::class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Please Enter Valid Code",
                                Toast.LENGTH_LONG
                            ).show()
                        }


                    })
            }

        })

        binding.resendCodeTv.setOnClickListener(View.OnClickListener {

            viewModel.number.observe(viewLifecycleOwner, Observer {
                mobileNumber = it
            })


            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(mobileNumber)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(requireActivity()) // Activity (for callback binding)
                .setCallbacks(callbacks)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)


        })

        binding.numberToolBar.backBtn.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        })

    }


    private fun showFragment (){
        Navigation.findNavController(binding.root).navigate(R.id.action_numberVerificationFragment_to_loginFragment)
    }

}