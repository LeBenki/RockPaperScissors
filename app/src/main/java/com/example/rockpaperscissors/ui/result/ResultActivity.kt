package com.example.rockpaperscissors.ui.result

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.Hand
import com.example.rockpaperscissors.model.getRandomHand

class ResultActivity : AppCompatActivity() {

    private lateinit var enemy: ImageView
    private lateinit var player: ImageView
    private lateinit var backToMenu: Button
    private lateinit var result: TextView

    private lateinit var playerHand: Hand
    private lateinit var enemyHand: Hand

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        bindViews()
        backToMenu.setOnClickListener { finish() }

        if (savedInstanceState != null)
            playerHand = Hand.valueOf(savedInstanceState.getString(PARAM_HAND)!!)
        else if (intent != null)
            playerHand = Hand.valueOf(intent.getStringExtra(PARAM_HAND)!!)

        enemyHand = getRandomHand()
        updateResultUI()
    }

    private fun bindViews() {
        enemy = findViewById(R.id.enemy_image)
        player = findViewById(R.id.player_image)
        backToMenu = findViewById(R.id.back_to_menu)
        result = findViewById(R.id.result_text)
    }

    private fun updateResultUI() {
        player.setImageResource(playerHand.resId)
        enemy.setImageResource(enemyHand.resId)

        when {
            playerHand.isWinningAgainst(enemyHand) -> {
                result.text = getString(R.string.win)
            }
            enemyHand.isWinningAgainst(playerHand) -> {
                result.text = getString(R.string.lose)
            }
            else -> {
                result.text = getString(R.string.draw)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(PARAM_HAND, playerHand.name)
    }

    companion object {
        const val PARAM_HAND = "PARAM_HAND"
    }
}