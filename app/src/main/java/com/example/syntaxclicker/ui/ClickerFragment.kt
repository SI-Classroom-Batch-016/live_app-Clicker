package com.example.syntaxclicker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.syntaxclicker.R
import com.example.syntaxclicker.databinding.FragmentClickerBinding
import com.example.syntaxclicker.viewmodels.ClickerViewModel


class ClickerFragment : Fragment() {



    private lateinit var binding: FragmentClickerBinding
    val viewModel: ClickerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClickerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()

        binding.clickBTN.setOnClickListener {


            //UI Event wird weitergegeben
            viewModel.click()

            //UI wird geupdated
            updateUI()
        }

        binding.clickBTN.setOnLongClickListener {

            viewModel.clickLong()

            updateUI()

            //true wenn der Click verarbeitet wurde,
            //false wenn der Click weiterhin gültig
            true
        }

        binding.easyModeFAB.setOnClickListener {

            viewModel.switchEasyMode()

            updateUI()
        }
    }

    //Diese Funktion soll das UI mit den Daten aus dem ViewModel updaten
    fun updateUI(){
        binding.scoreTV.text = viewModel.score.toString()
        if(viewModel.easyMode){
            binding.easyModeTV.text = "Easy Mode"
        } else {
            binding.easyModeTV.text = "Hard Mode"
        }
    }

}