package com.example.mutirecyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mutirecyclerview.DetailActivity
import com.example.mutirecyclerview.R
import com.example.mutirecyclerview.entity.AssembleEntity

class MuTiAdapter(
    private val itemList: ArrayList<AssembleEntity> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /*interface ItemClick {
        fun onItemClick(item: AssembleEntity)
    }

    var itemClick: ItemClick? = null*/

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        return when (item) {
            is AssembleEntity.TopModel -> TYPE_TOP
            is AssembleEntity.MiddleModel -> TYPE_MIDDLE
            is AssembleEntity.BottomModel -> TYPE_BOTTOM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TOP -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_top, parent, false)
                ViewHolderTop(view)
            }
            TYPE_MIDDLE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_middle, parent, false)
                ViewHolderMiddle(view)
            }
            TYPE_BOTTOM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_bottom, parent, false)
                ViewHolderBottom(view)
            }
            else -> {
                throw RuntimeException("오류")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {
            TYPE_TOP -> initLayoutTop(holder as ViewHolderTop, position)
            TYPE_MIDDLE -> initLayoutMiddle(holder as ViewHolderMiddle, position)
            TYPE_BOTTOM -> initLayoutBottom(holder as ViewHolderBottom, position)
            else -> {
            }
        }
    }

    private fun initLayoutTop(holder: ViewHolderTop, pos: Int) {
        val item = itemList[pos] as AssembleEntity.TopModel
        holder.item1.text = item.name
        holder.item2.text = item.cardNumber
        holder.item3.text = item.validity
        holder.item4.text = item.currentMoney
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PLUG_IN, item)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    private fun initLayoutMiddle(holder: ViewHolderMiddle, pos: Int) {
        val item = itemList[pos] as AssembleEntity.MiddleModel
        holder.item1.text = item.name
        holder.item2.text = item.cardNumber
        holder.item3.text = item.validity
        holder.item4.text = item.currentMoney
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PLUG_IN2, item)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    private fun initLayoutBottom(holder: ViewHolderBottom, pos: Int) {
        val item = itemList[pos] as AssembleEntity.BottomModel
        holder.item1.text = item.name
        holder.item2.text = item.cardNumber
        holder.item3.text = item.validity
        holder.item4.text = item.currentMoney
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PLUG_IN3, item)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    inner class ViewHolderTop(view: View) : RecyclerView.ViewHolder(view) {
        var item1: TextView = itemView.findViewById<TextView>(R.id.nameTextView)!!
        var item2: TextView = itemView.findViewById<TextView>(R.id.cardNumberTextView)!!
        var item3: TextView = itemView.findViewById<TextView>(R.id.validityTextView)!!
        var item4: TextView = itemView.findViewById<TextView>(R.id.moneyTextView)!!
    }

    inner class ViewHolderMiddle(view: View) : RecyclerView.ViewHolder(view) {
        var item1: TextView = itemView.findViewById<TextView>(R.id.nameTextView)!!
        var item2: TextView = itemView.findViewById<TextView>(R.id.cardNumberTextView)!!
        var item3: TextView = itemView.findViewById<TextView>(R.id.validityTextView)!!
        var item4: TextView = itemView.findViewById<TextView>(R.id.moneyTextView)!!
    }

    inner class ViewHolderBottom(view: View) : RecyclerView.ViewHolder(view) {
        var item1: TextView = itemView.findViewById<TextView>(R.id.nameTextView)!!
        var item2: TextView = itemView.findViewById<TextView>(R.id.cardNumberTextView)!!
        var item3: TextView = itemView.findViewById<TextView>(R.id.validityTextView)!!
        var item4: TextView = itemView.findViewById<TextView>(R.id.moneyTextView)!!

    }

    companion object {
        private const val TYPE_TOP = 1
        private const val TYPE_MIDDLE = 2
        private const val TYPE_BOTTOM = 3
    }
}