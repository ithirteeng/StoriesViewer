package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        binding.container.button.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.resources.getString(R.string.bostonSource)))
            startActivity(browserIntent)
        }

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
        changeStoriesData.makeImage(
            resources.getDrawable(
                R.drawable.boston_picture,
                requireContext().theme
            ), requireContext()
        )
        changeStoriesData.updateView(1, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(FirstStory(), R.id.secondContainer, ThirdStory(), binding.root).navigate(
            width,
            activity?.supportFragmentManager
        )
    }
}