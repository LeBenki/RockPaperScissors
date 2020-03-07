package com.example.rockpaperscissors.ui.choose_hand

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Hand

class ChooseHandAdapter(private val hands: List<Hand>) : RecyclerView.Adapter<ChooseHandViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChooseHandViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.viewholder_hand, parent, false))

    override fun getItemCount() = hands.size

    override fun onBindViewHolder(holder: ChooseHandViewHolder, position: Int) = holder.bind(hands[position])
}