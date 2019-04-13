package com.tictak.tictaktoe

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class playwithcomputerActivity : AppCompatActivity() {

    enum class PLAYINGPLAYER {

        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER_OF_GAME {

        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playwithcomputer)

        playingPlayer = PLAYINGPLAYER.FIRST_PLAYER
        try{
            startService(
                Intent(this@playwithcomputerActivity,
                    SoundService::class.java)
            )
        }catch (e: Exception){
            e.printStackTrace()
        }




    }

    // Instance Variable

    var playingPlayer: PLAYINGPLAYER? = null
    var winnerOfGame: WINNER_OF_GAME? = null

    var player1Options: ArrayList<Int> = ArrayList()
    var player2Options: ArrayList<Int> = ArrayList()
    var allDisabledImages: ArrayList<ImageButton?> = ArrayList()

    fun imageButoonTapped(view: View) {

        val selectedImageButton: ImageButton = view as ImageButton
        var randomNumber = (Math.random() * 9 + 1).toInt()

        when(randomNumber){

            1 -> title_table_row.setBackgroundColor(Color.YELLOW)
            2 -> title_table_row.setBackgroundColor(Color.LTGRAY)
            3 -> title_table_row.setBackgroundColor(Color.WHITE)
            4 -> title_table_row.setBackgroundColor(Color.YELLOW)
            5 -> title_table_row.setBackgroundColor(Color.CYAN)
            6 -> title_table_row.setBackgroundColor(Color.MAGENTA)
            7 -> title_table_row.setBackgroundColor(Color.GREEN)
            8 -> title_table_row.setBackgroundColor(Color.RED)
            9 -> title_table_row.setBackgroundColor(Color.WHITE)
        }

        var optionNumber = 0

        when(selectedImageButton.id){

            R.id.imgButton1 -> optionNumber = 1
            R.id.imgButton2 -> optionNumber = 2
            R.id.imgButton3 -> optionNumber = 3
            R.id.imgButton4 -> optionNumber = 4
            R.id.imgButton5 -> optionNumber = 5
            R.id.imgButton6 -> optionNumber = 6
            R.id.imgButton7 -> optionNumber = 7
            R.id.imgButton8 -> optionNumber = 8
            R.id.imgButton9 -> optionNumber = 9
        }

        action(optionNumber, selectedImageButton)


    }

    private fun action(optionNumber: Int, _selectedImageButton: ImageButton ){

        var selectedImageButton = _selectedImageButton

        if(playingPlayer == PLAYINGPLAYER.FIRST_PLAYER) {

            selectedImageButton.setImageResource(R.drawable.x)
            player1Options.add(optionNumber)
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingPlayer = PLAYINGPLAYER.SECOND_PLAYER
        }
        if(playingPlayer == PLAYINGPLAYER.SECOND_PLAYER) {
            // Algorithm for playing with ourselves
//            selectedImageButton.setImageResource(R.drawable.o)
//            player2Options.add(optionNumber)
//            selectedImageButton.isEnabled = false
//            allDisabledImages.add(selectedImageButton)
//            playingPlayer = PLAYINGPLAYER.FIRST_PLAYER

           //Algorithm for playing with a computer
            var notselectedImageNumbers = ArrayList<Int>()

            for (imageNumber in 1..9){

                if (!(player1Options.contains(imageNumber))){

                    if(!(player2Options.contains(imageNumber))){
                        notselectedImageNumbers.add(imageNumber)
                    }
                }
            }

            try {
                var randomNumber = ((Math.random() * notselectedImageNumbers.size)).toInt()
                var imageNumber = notselectedImageNumbers[randomNumber]

                when(imageNumber){

                    1 -> selectedImageButton = imgButton1
                    2 -> selectedImageButton = imgButton2
                    3 -> selectedImageButton = imgButton3
                    4 -> selectedImageButton = imgButton4
                    5 -> selectedImageButton = imgButton5
                    6 -> selectedImageButton = imgButton6
                    7 -> selectedImageButton = imgButton7
                    8 -> selectedImageButton = imgButton8
                    9 -> selectedImageButton = imgButton9

                }

                selectedImageButton.setImageResource(R.drawable.o)
                player2Options.add(imageNumber)
                selectedImageButton.isEnabled = false
                allDisabledImages.add(selectedImageButton)
                playingPlayer = PLAYINGPLAYER.FIRST_PLAYER


            }catch (e: Exception){
                e.printStackTrace()
            }


        }

        specifyTheWinnerOfGame()

    }
    private fun specifyTheWinnerOfGame(){

        if(player1Options.contains(1)
            && player1Options.contains(2)
            && player1Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player2Options.contains(1)
            && player2Options.contains(2)
            && player2Options.contains(3)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(4)
            && player1Options.contains(5)
            && player1Options.contains(6)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(4)
            && player2Options.contains(5)
            && player2Options.contains(6)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(7)
            && player1Options.contains(8)
            && player1Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(7)
            && player2Options.contains(8)
            && player2Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(1)
            && player1Options.contains(4)
            && player1Options.contains(7)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(1)
            && player2Options.contains(4)
            && player2Options.contains(7)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(2)
            && player1Options.contains(5)
            && player1Options.contains(8)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        }  else if(player2Options.contains(2)
            && player2Options.contains(5)
            && player2Options.contains(8)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(3)
            && player1Options.contains(6)
            && player1Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(3)
            && player2Options.contains(6)
            && player2Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }  else if(player1Options.contains(1)
            && player1Options.contains(5)
            && player1Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(1)
            && player2Options.contains(5)
            && player2Options.contains(9)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        } else if(player1Options.contains(3)
            && player1Options.contains(5)
            && player1Options.contains(7)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_ONE

        } else if(player2Options.contains(3)
            && player2Options.contains(5)
            && player2Options.contains(7)){

            winnerOfGame = WINNER_OF_GAME.PLAYER_TWO

        }

        if(winnerOfGame == WINNER_OF_GAME.PLAYER_ONE){

            createAlert("Player one Wins",
                "Congratulations to Player 1",
                AlertDialog.BUTTON_POSITIVE, "OK", false)

            return

        } else if(winnerOfGame == WINNER_OF_GAME.PLAYER_TWO){

            createAlert("Player Two Wins", "Congratulations to Player 2",
                AlertDialog.BUTTON_POSITIVE, "OK", false)
            return

        }

        checkDrawState()


    }

    private fun createAlert(title: String, message: String, whichButton: Int,
                            buttonText: String, cancelable: Boolean){

        var alertDialog: AlertDialog = AlertDialog.Builder(this@playwithcomputerActivity).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        alertDialog.setButton(whichButton, buttonText, {

                dialog: DialogInterface?, which: Int ->

            resetGame()

        })

        alertDialog.setCancelable(cancelable)

        alertDialog.show()



    }

    private fun resetGame(){

        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerOfGame = WINNER_OF_GAME.NO_ONE
        playingPlayer =PLAYINGPLAYER.FIRST_PLAYER

        imgButton1.setImageResource(R.drawable.back_img)
        imgButton2.setImageResource(R.drawable.back_img)
        imgButton3.setImageResource(R.drawable.back_img)
        imgButton4.setImageResource(R.drawable.back_img)
        imgButton5.setImageResource(R.drawable.back_img)
        imgButton6.setImageResource(R.drawable.back_img)
        imgButton7.setImageResource(R.drawable.back_img)
        imgButton8.setImageResource(R.drawable.back_img)
        imgButton9.setImageResource(R.drawable.back_img)

        imgButton1.isEnabled = true
        imgButton2.isEnabled = true
        imgButton3.isEnabled = true
        imgButton4.isEnabled = true
        imgButton5.isEnabled = true
        imgButton6.isEnabled = true
        imgButton7.isEnabled = true
        imgButton8.isEnabled = true
        imgButton9.isEnabled = true



    }

    private fun checkDrawState(){

        if(allDisabledImages.size == 9 && winnerOfGame != WINNER_OF_GAME.PLAYER_ONE
            && winnerOfGame != WINNER_OF_GAME.PLAYER_TWO){

            createAlert("DRAW!!", " NO ONE WON THE GAME!",
                AlertDialog.BUTTON_POSITIVE, "OK", false)
        }



    }

}
