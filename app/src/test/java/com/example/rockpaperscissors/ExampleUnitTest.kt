package com.example.rockpaperscissors

import com.example.rockpaperscissors.model.Hand
import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun checkHandWinning() {
        val rock = Hand.ROCK
        val paper = Hand.PAPER
        val scissors = Hand.SCISSORS

        assertTrue(rock.isWinningAgainst(scissors))
        assertTrue(scissors.isWinningAgainst(paper))
        assertTrue(paper.isWinningAgainst(rock))
    }
}
