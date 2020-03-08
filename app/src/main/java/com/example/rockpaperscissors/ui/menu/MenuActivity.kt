package com.example.rockpaperscissors.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rockpaperscissors.R
import com.example.rockpaperscissors.model.getRandomHand
import com.example.rockpaperscissors.ui.choose_hand.ChooseHandActivity
import com.example.rockpaperscissors.ui.result.ResultActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun launchPlayerMode(view: View) {
        startActivity(Intent(this, ChooseHandActivity::class.java))
    }

    fun launchCPUMode(view: View) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra(ResultActivity.PARAM_HAND, getRandomHand().name)
        startActivity(intent)
    }
}
