package com.project.android.wordguessgame.screens.game

import androidx.lifecycle.ViewModel
// ViewModel containing all the logic needed to run the game

class GameViewModel : ViewModel() {
    // The current word
    var word = ""
    // The current score
    var score = 0
    // The list of all the words
    private lateinit var wordList: MutableList<String>
    // Resets the list of words and randomizes the order
    private fun resetList() {
        wordList = mutableListOf(
                "Run",
                "Car",
                "Beer",
                "king",
                "change",
                "snail",
                "cap",
                "calendar",
                "happy",
                "chair",
                "bottle",
                "sad",
                "airport",
                "dance",
                "happy",
                "smile",
                "duck",
                "lion",
                "mug",
                "sing",
                "watch"
        )
        wordList.shuffle()  // Shuffling all the words
    }
    // Initializing the functions which are required to jump to next word and to reset the list when
    // clicked on "Skip" and "Got it" button
    init {
        resetList()
        nextWord()
    }
    // Callback called when the ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
    }
    // Score gets deducted by 1 if skipped
    fun onSkip() {
        score--
        nextWord()
    }
    // Score increases by 1 if the guess was correct
    fun onCorrect() {
        score++
        nextWord()
    }
    // Moves to the next word in the list.
    private fun nextWord() {
        //Select and removes the first word from the list
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }
}
