package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.UI.MyViewModel
import com.example.myapplication.UI.adapters.ClientAdapter
import com.example.myapplication.commons.RequestStatus
import com.example.myapplication.data.domain.Client
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ClientAdapter
    private lateinit var intent: Intent
    private val clientsViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureRecycler()
        observer()
    }

    private fun configureRecycler() {
        adapter = ClientAdapter(::goDetails)
        binding.rcClients.adapter = adapter
    }

    private fun observer() {
        clientsViewModel.getData().observe(this) { result ->
            when (result) {
                is RequestStatus.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is RequestStatus.Error -> {
                    binding.progressBar.visibility = View.GONE
                }

                is RequestStatus.Sucess -> {
                    binding.progressBar.visibility = View.GONE
                    print(result)
                    adapter.setUpClients(result.data)
                }
            }
        }
    }

    private fun goDetails(input: Client) {
        intent = Intent(this, DetailActivity::class.java)

        intent.apply {
            putExtra("data", input)
            startActivity(intent)
        }
    }
}