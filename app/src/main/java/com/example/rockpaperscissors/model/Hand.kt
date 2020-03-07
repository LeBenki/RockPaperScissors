package com.example.rockpaperscissors.model

import com.example.rockpaperscissors.R

enum class Hand (val id: Int, val resId: Int, val winsAgainst: List<Int>) {
    ROCK(0, R.drawable.rock, listOfNotNull(2)),
    PAPER(1, R.drawable.rock, listOfNotNull(0)),
    SCISSORS(2, R.drawable.rock, listOfNotNull(1));

    fun isWinningAgainst(hand: Hand) = (hand.winsAgainst.contains(hand.id))
}