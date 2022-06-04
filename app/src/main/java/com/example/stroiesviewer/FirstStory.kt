package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.stroiesviewer.databinding.FragmentFirstStoryBinding

class FirstStory : Fragment(R.layout.fragment_first_story) {
    private lateinit var binding: FragmentFirstStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstStoryBinding.inflate(layoutInflater)
        changeData()
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Нью-Йорк,США")
        changeStoriesData.changeTimeText("9 - 22 сентября")
        changeStoriesData.changeHeaderText("Архитектура")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(resources.getDrawable(R.drawable.new_york_picture, requireContext().theme))
        changeStoriesData.updateView(0, requireContext())
    }


}