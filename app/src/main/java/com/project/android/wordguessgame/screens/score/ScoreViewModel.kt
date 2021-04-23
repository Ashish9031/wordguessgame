package com.project.android.wordguessgame.screens.score

import androidx.lifecycle.ViewModel

// ViewModel for the final screen showing the score
class ScoreViewModel(finalScore: Int) : ViewModel() {
    // The final score
    var score = finalScore
    init {
    }
}
