package com.project.theandroidcrew.hoverhackaton.views.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.theandroidcrew.hoverhackaton.databinding.ItemBankSelectItemBinding

class BankSelectAdapter(val clickListener: BankClickListener) : ListAdapter<String, BankSelectAdapter.MyViewHolder>(BankDiffCallback()) {
    class MyViewHolder(
        val binding: ItemBankSelectItemBinding,
        val clickListener: BankClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(bank: String) {
            binding.bankCardView.setOnClickListener { clickListener.onClick(bank) }
            binding.bankName.text = bank
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return from(parent)
        }

        private fun from(parent: ViewGroup): MyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBankSelectItemBinding.inflate(layoutInflater, parent, false)
            return MyViewHolder(binding, clickListener)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val name = getItem(position)
            holder.bind(name)
        }
}


class BankClickListener(val clickListener: (bank: String) -> Unit){
    fun onClick(bank: String) = clickListener(bank)
}

class BankDiffCallback : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
