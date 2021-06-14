package com.lucascabral.customviewprogressbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.lucascabral.customviewprogressbutton.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainProgressButton.setOnClickListener {
            binding.mainProgressButton.setLoading()
            lifecycleScope.launch {
                delay(3_000)
                binding.mainProgressButton.setNormal()
            }
        }
    }
}