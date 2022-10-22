package com.moashrafff.nectar.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moashrafff.nectar.R
import com.moashrafff.nectar.databinding.ActivityStartingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartingActivity : AppCompatActivity() {

    private val binding by lazy { ActivityStartingBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}