package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.data.domain.Client
import com.example.myapplication.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val clientBundle = intent.extras?.getSerializable("data") as? Client
        print(clientBundle)

        binding.tvClientName.text = clientBundle?.name
        binding.tvClientCpf.text = clientBundle?.cpf
        binding.tvClientEmail.text = clientBundle?.email
//        binding.tvClientIsEnabled.isEnabled = clientBundle!!.isEnabled || false
    }
}