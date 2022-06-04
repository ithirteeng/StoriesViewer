package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stroiesviewer.databinding.FragmentSecondStoryBinding
import com.example.stroiesviewer.databinding.FragmentThirdStoryBinding


class ThirdStory : Fragment(R.layout.fragment_third_story) {
    private lateinit var binding: FragmentThirdStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdStoryBinding.inflate(layoutInflater)
        changeData()
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Нью-Дели,Индия")
        changeStoriesData.changeTimeText("2 - 4 июня")
        changeStoriesData.changeHeaderText("Рестораны")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.india_picture,
                requireContext().theme
            )
        )
        changeStoriesData.updateView(2, requireContext())
    }
}