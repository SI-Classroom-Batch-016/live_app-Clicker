package com.example.syntaxclicker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.syntaxclicker.R
import com.example.syntaxclicker.databinding.FragmentResultBinding
import com.example.syntaxclicker.viewmodels.ClickerViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val viewModel: ClickerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region UI Event Listener

        binding.resetBTN.setOnClickListener {

            findNavController().navigateUp()

            viewModel.restart()

        }

        //endregion

        //region Observer die das UI mit Daten verbinden

        viewModel.score.observe(viewLifecycleOwner){score ->

            binding.resultTV.text = "Spiel abgeschlossen! Du hast $score  Punkte erreicht."

        }

        //endregion


    }


}