package com.example.rockpaperscissors.ui.choose_hand

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Hand

class ChooseHandViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val handName: TextView = view.findViewById(R.id.viewholder_text)
    private val handImage: ImageView = view.findViewById(R.id.viewholder_image)

    fun bind(hand: Hand) {
        handName.text = hand.name
        handImage.setImageResource(hand.resId)
    }
}