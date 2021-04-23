package com.project.android.wordguessgame.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.android.wordguessgame.R
import com.project.android.wordguessgame.databinding.ScoreFragmentBinding

// Fragment where the final score is shown, after the game is over
class ScoreFragment : Fragment() {
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflating the respective fragment file to this file
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.score_fragment,
                container,
                false
        )
        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(ScoreViewModel::class.java)
        // Setting the final score to its tetview
        binding.scoreText.text = viewModel.score.toString()
        return binding.root
    }
}
