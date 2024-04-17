package com.example.mutirecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mutirecyclerview.adapter.MuTiAdapter
import com.example.mutirecyclerview.databinding.ActivityMainBinding
import com.example.mutirecyclerview.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate( layoutInflater ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
    }

    private fun initViews() {
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAllData()
        viewModel.assamble.observe(this, Observer { data ->
            val muTiAdapter = MuTiAdapter(data)
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.itemAnimator = DefaultItemAnimator()
            binding.recyclerView.adapter = muTiAdapter
        })
    }
}