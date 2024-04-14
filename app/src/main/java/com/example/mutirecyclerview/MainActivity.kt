package com.example.mutirecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mutirecyclerview.adapter.MuTiAdapter
import com.example.mutirecyclerview.databinding.ActivityMainBinding
import com.example.mutirecyclerview.entity.AssembleEntity

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
        val itemList = ArrayList<AssembleEntity>()
        val muTiAdapter = MuTiAdapter(itemList)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = muTiAdapter


        itemList.add(AssembleEntity.TopModel(name = "Anderson", cardNumber = "2423  3581  9503  2412", validity = "21/24", currentMoney = "$${String.format("%,f", 3100.3)}"))
        itemList.add(AssembleEntity.MiddleModel(name = "Andrew", cardNumber = "2423  3581  9503  2412", validity = "21/24", currentMoney = "$${String.format("%,f", 3100.3)}"))
        itemList.add(AssembleEntity.BottomModel(name = "SMITH", cardNumber = "2423  3581  9503  2412", validity = "21/24", currentMoney = "$${String.format("%,f", 3100.3)}"))
    }
}