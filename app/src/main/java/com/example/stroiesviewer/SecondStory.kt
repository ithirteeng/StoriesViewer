package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.stroiesviewer.databinding.FragmentSecondStoryBinding


class SecondStory : Fragment(R.layout.fragment_second_story) {
    private lateinit var binding: FragmentSecondStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondStoryBinding.inflate(layoutInflater)
        changeData()
        toAnotherFragments()
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Бостон, США")
        changeStoriesData.changeTimeText("3 - 13 августа")
        changeStoriesData.changeHeaderText("Улицы")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.boston_picture,
                requireContext().theme
            )
        )
        changeStoriesData.updateView(1, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(R.id.firstStory, R.id.thirdStory, binding.root).navigate(width, findNavController())
    }
}