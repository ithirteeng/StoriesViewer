package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.stroiesviewer.databinding.FragmentFifthStoryBinding

class FifthStory : Fragment() {
    private lateinit var binding: FragmentFifthStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthStoryBinding.inflate(layoutInflater)
        changeData()
        toAnotherFragments()
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Москва, Россия")
        changeStoriesData.changeTimeText("14 - 20 Июля")
        changeStoriesData.changeHeaderText("Достопримечательности")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.moscow_picture,
                requireContext().theme
            )
        )
        changeStoriesData.updateView(4, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(R.id.fourthStory, null, binding.root).navigate(width, findNavController())
    }
}