package com.tictak.tictaktoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_option.*

class optionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        YoYo.with(Techniques.Pulse)
            .duration(700)
            .repeat(3)
            .playOn(computer_button)

        YoYo.with(Techniques.Pulse)
            .duration(700)
            .repeat(3)
            .playOn(player_button)


        player_button.setOnClickListener {

            var intent = Intent(this, TicTacToeActivity::class.java)
            startActivity(intent)
        }

        computer_button.setOnClickListener {

            var intent = Intent(this, playwithcomputerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun playAnimationOnView(view: View, techniques: Techniques){
        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(1)
            .playOn(view)
    }
}
