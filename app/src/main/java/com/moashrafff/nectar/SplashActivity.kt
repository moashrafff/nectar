package com.moashrafff.nectar

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.moashrafff.nectar.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lifecycleScope.launchWhenResumed { navigateToResultPage() }

    }



    private suspend fun navigateToResultPage() {
        delay(2000)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}