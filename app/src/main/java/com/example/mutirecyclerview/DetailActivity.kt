package com.example.mutirecyclerview

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mutirecyclerview.databinding.ActivityDetailBinding
import com.example.mutirecyclerview.entity.AssembleEntity

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate( layoutInflater ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bindView()
    }

    private fun bindView() {
        if (intent.hasExtra(PLUG_IN)) {
            val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getParcelableExtra(PLUG_IN, AssembleEntity.TopModel::class.java)!!
            } else {
                intent?.getParcelableExtra<AssembleEntity.TopModel>(PLUG_IN) as AssembleEntity.TopModel
            }

            binding.nameTextView.text = data.name
            binding.cardNumberTextView.text = data.cardNumber
            binding.validityTextView.text = data.validity
            binding.moneyTextView.text = data.currentMoney
        } else if(intent.hasExtra(PLUG_IN2)) {
            val data2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getParcelableExtra(PLUG_IN2, AssembleEntity.MiddleModel::class.java)!!
            } else {
                intent?.getParcelableExtra<AssembleEntity.MiddleModel>(PLUG_IN2) as AssembleEntity.MiddleModel
            }

            binding.nameTextView.text = data2.name
            binding.cardNumberTextView.text = data2.cardNumber
            binding.validityTextView.text = data2.validity
            binding.moneyTextView.text = data2.currentMoney
        } else if(intent.hasExtra(PLUG_IN3)) {
            val data3 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getParcelableExtra(PLUG_IN3, AssembleEntity.BottomModel::class.java)!!
            } else {
                intent?.getParcelableExtra<AssembleEntity.BottomModel>(PLUG_IN3) as AssembleEntity.BottomModel
            }

            binding.nameTextView.text = data3.name
            binding.cardNumberTextView.text = data3.cardNumber
            binding.validityTextView.text = data3.validity
            binding.moneyTextView.text = data3.currentMoney
        }
    }

    companion object {
        const val PLUG_IN = "plugin"
        const val PLUG_IN2 = "plugin2"
        const val PLUG_IN3 = "plugin3"
    }
}