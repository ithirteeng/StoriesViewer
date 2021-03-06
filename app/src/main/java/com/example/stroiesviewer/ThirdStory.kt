package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        toAnotherFragments()

        binding.container.button.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.resources.getString(R.string.newDeliSource)))
            startActivity(browserIntent)
        }

        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Нью-Дели, Индия")
        changeStoriesData.changeTimeText("2 - 4 июня")
        changeStoriesData.changeHeaderText("Рестораны")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.india_picture,
                requireContext().theme
            )
        )
        changeStoriesData.makeImage(
            resources.getDrawable(
                R.drawable.india_picture,
                requireContext().theme
            ), requireContext()
        )
        changeStoriesData.updateView(2, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(SecondStory(), R.id.thirdContainer, FourthStory(), binding.root).navigate(
            width,
            activity?.supportFragmentManager
        )
    }
}