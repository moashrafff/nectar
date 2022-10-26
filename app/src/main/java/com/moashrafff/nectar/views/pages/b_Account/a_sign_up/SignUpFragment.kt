package com.moashrafff.nectar.views.pages.b_Account.a_sign_up

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.moashrafff.nectar.config.Constants
import com.moashrafff.nectar.databinding.FragmentSignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class SignUpFragment : Fragment() {

    private val binding by lazy { FragmentSignUpBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    val user: HashMap<String, Any> = HashMap()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth
        db = FirebaseFirestore.getInstance()

        binding.signupBtn.setOnClickListener(View.OnClickListener {
            registerUser()
            binding.loginEmailEt.text?.clear()
            binding.loginPassEt.text?.clear()
            binding.regNameEt.text?.clear()

        })

    }

    private fun registerUser() {
        val email = binding.loginEmailEt.text.toString()
        val password = binding.loginPassEt.text.toString()
        val username = binding.regNameEt.text.toString()

        user[Constants.USER_USERNAME_KEY] = username
        user[Constants.USER_EMAIL_KEY] = email
        user[Constants.USER_PASSWORD_KEY] = password

        if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()) {

            CoroutineScope(Dispatchers.IO).launch {
                try {

                    auth.createUserWithEmailAndPassword(email, password).await()
                    saveUserIntoFireBase()
                    withContext(Dispatchers.Main) {
                        checkLoggedState()
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
                    }


                }
            }
        }


    }


    private fun checkLoggedState() {
        if (auth.currentUser == null) {
            Toast.makeText(requireContext(), "You are not logged", Toast.LENGTH_LONG).show()
        }
    }

    private fun saveUserIntoFireBase() {
        db.collection("user").add(user)
            .addOnSuccessListener { documentReference ->
                Log.e("", "Login success")
            }
            .addOnFailureListener { e ->
                Log.e("", "Login fail")
            }
    }


}