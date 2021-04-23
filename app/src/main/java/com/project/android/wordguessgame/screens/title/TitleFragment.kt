package com.project.android.wordguessgame.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.android.wordguessgame.R
import com.project.android.wordguessgame.databinding.TitleFragmentBinding

// Fragment for the starting or title screen of the app
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflating the respective fragment file to this file
        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.title_fragment, container, false)

        // When clicked on the play game button, it navigates to another fragment
        binding.playGameButton.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleToGame())
        }
        return binding.root
    }
}
