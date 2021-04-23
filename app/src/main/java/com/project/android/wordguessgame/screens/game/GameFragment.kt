package com.project.android.wordguessgame.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.project.android.wordguessgame.R
import com.project.android.wordguessgame.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    // Using the data binding technique
    private lateinit var binding: GameFragmentBinding

    // Using the view model
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflating the respective fragment file to this file
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )

        // Get the viewModel
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        // Setting the click listener to the button and calling onCorrect method
        binding.correctButton.setOnClickListener { onCorrect() }
        // Setting the click listener to the button and calling onSkip method
        binding.skipButton.setOnClickListener { onSkip() }
        // Setting the click listener to the button and calling onEndGame method
        binding.endGameButton.setOnClickListener { onEndGame() }
        // Updating the score depending if the answer was correct or skipped
        updateScoreText()
        // Updating the word text, to get the new word after a guessing
        updateWordText()
        return binding.root
    }

    // Methods for buttons clicks

    private fun onSkip() {
        viewModel.onSkip()
        // Updating the word text, to get the new word after a guessing
        updateWordText()
        // Updating the score depending if the answer was correct or skipped
        updateScoreText()
    }
    private fun onCorrect() {
        viewModel.onCorrect()
        // Updating the score depending if the answer was correct or skipped
        updateScoreText()
        // Updating the word text, to get the new word after a guessing
        updateWordText()
    }

    private fun onEndGame() {
        // Calling the method when the game is finished
        gameFinished()
    }

    // Method for updating the word
    private fun updateWordText() {
        binding.wordText.text = viewModel.word
    }

    // Method for updating the score
    private fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }

    // Called when the game is finished and displays the final score
    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameToScore()
        action.score = viewModel.score
        NavHostFragment.findNavController(this).navigate(action)
    }
}
