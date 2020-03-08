package com.example.rockpaperscissors.model

import com.example.rockpaperscissors.R

fun getRandomHand(): Hand {
    return Hand.values()[(0..2).random()]
}

enum class Hand (val resId: Int, val winsAgainst: List<String>) {
    ROCK(R.drawable.rock, listOfNotNull("SCISSORS")),
    PAPER(R.drawable.paper, listOfNotNull("ROCK")),
    SCISSORS( R.drawable.scissors, listOfNotNull("PAPER"));

    fun isWinningAgainst(hand: Hand) = (winsAgainst.contains(hand.name))
}