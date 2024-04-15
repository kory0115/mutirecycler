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
import java.text.DecimalFormat

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


        val decimal2 = DecimalFormat("#,###.00")

        itemList.add(AssembleEntity.TopModel(name = "Anderson", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
        itemList.add(AssembleEntity.MiddleModel(name = "Andrew", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
        itemList.add(AssembleEntity.BottomModel(name = "SMITH", cardNumber = cardNumberView("2423358195032412"), validity = resultView("2124"), currentMoney = "$${decimal2.format(3100.30)}"))
    }

    private fun resultView(s : String) : String{
        var re : String = ""
        val result: Array<String> = s.toCharArray().map { it.toString() }.toTypedArray()
        for(i in result.indices) {
            re += result[i]
            if(i == 1) {
                re += "/"
            }
        }
        return re
    }

    private fun cardNumberView(s : String) : String {
        var card : String = ""
        val result: Array<String> = s.toCharArray().map { it.toString() }.toTypedArray()
        for(i in result.indices) {
            card += result[i]
            if(i == 3 || i == 7 || i == 11 || i == 15) {
                card += "  "
            }
        }
        return card
    }
}