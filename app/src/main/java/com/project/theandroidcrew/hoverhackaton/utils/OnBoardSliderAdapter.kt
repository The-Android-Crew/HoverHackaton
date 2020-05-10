package com.project.theandroidcrew.hoverhackaton.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.theandroidcrew.hoverhackaton.R

class OnBoardSliderAdapter(private val onBoardSlides: List<OnBoardSlide>) :
    RecyclerView.Adapter<OnBoardSliderAdapter.OnBoardSlideViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardSlideViewHolder {
        return OnBoardSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_items_container,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return onBoardSlides.size
    }

    override fun onBindViewHolder(holder: OnBoardSlideViewHolder, position: Int) {
        holder.bind(onBoardSlides[position])
    }

    inner class OnBoardSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.itemTV)
        private val image = view.findViewById<ImageView>(R.id.itemImageView)

        fun bind(onBoardSlide: OnBoardSlide) {
            textTitle.text = onBoardSlide.title
            image.setImageResource(onBoardSlide.icon)
        }

    }
}