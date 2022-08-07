package com.tejas558.tic_tac_toe_l

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var prohibit = 0
    fun buttonClicked(view:View){
        if(prohibit == 1) return
        val selectedElement = view as Button
        var bnClicked = -1
        when(selectedElement.id){
            R.id.BNbutton1 -> bnClicked = 1
            R.id.BNbutton2 -> bnClicked = 2
            R.id.BNbutton3 -> bnClicked = 3
            R.id.Bnbutton4 -> bnClicked = 4
            R.id.BNbutton5 -> bnClicked = 5
            R.id.BNbutton6 -> bnClicked = 6
            R.id.BNbutton7 -> bnClicked = 7
            R.id.BNbutton8 -> bnClicked = 8
            R.id.BNbutton9 -> bnClicked = 9
        }
        Log.d("You have clicked: ", bnClicked.toString())
        makeGameMove(bnClicked, selectedElement)
    }

    var currPlayer = 2
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun makeGameMove(bnClicked:Int, button:Button){
        if(button.text != "") return

        if(currPlayer == 2) currPlayer = 1
        else currPlayer = 2

        if(currPlayer == 1){
            button.text = "X"
            player1.add(bnClicked)
            button.setBackgroundResource(R.color.light_blue)
        }
        else{
            button.text = "O"
            player2.add(bnClicked)
            button.setBackgroundResource(R.color.light_pink)
        }

        findWinner()
    }

    fun findWinner(){
        var winner = -1

        // rows
        val r1 = listOf(1, 2, 3)
        if(player1.containsAll(r1)) winner = 1
        if(player2.containsAll(r1)) winner = 2
        val r2 = listOf(4, 5, 6)
        if(player1.containsAll(r2)) winner = 1
        if(player2.containsAll(r2)) winner = 2
        val r3 = listOf(7, 8, 9)
        if(player1.containsAll(r3)) winner = 1
        if(player2.containsAll(r3)) winner = 2

        // columns
        val c1 = listOf(1, 4, 7)
        if(player1.containsAll(c1)) winner = 1
        if(player2.containsAll(c1)) winner = 2
        val c2 = listOf(2, 5, 8)
        if(player1.containsAll(c2)) winner = 1
        if(player2.containsAll(c2)) winner = 2
        val c3 = listOf(3, 6, 9)
        if(player1.containsAll(c3)) winner = 1
        if(player2.containsAll(c3)) winner = 2

        // diagonals
        val d1 = listOf(1, 5, 9)
        if(player1.containsAll(d1)) winner = 1
        if(player2.containsAll(d1)) winner = 2
        val d2 = listOf(3, 5, 7)
        if(player1.containsAll(d2)) winner = 1
        if(player2.containsAll(d2)) winner = 2

        if(winner != -1){
            Toast.makeText(this, "Player $winner has won the game", Toast.LENGTH_LONG).show()
            prohibit = 1
        }
    }
}