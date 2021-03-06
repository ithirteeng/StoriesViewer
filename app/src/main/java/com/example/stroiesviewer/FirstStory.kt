package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
        toAnotherFragments()

        binding.container.button.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.resources.getString(R.string.newYorkSource)))
            startActivity(browserIntent)
        }

        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi", "ResourceType")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Нью-Йорк, США")
        changeStoriesData.changeTimeText("9 - 22 сентября")
        changeStoriesData.changeHeaderText("Архитектура")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.new_york_picture,
                requireContext().theme
            )
        )

        changeStoriesData.makeImage(
            resources.getDrawable(
                R.drawable.new_york_picture,
                requireContext().theme
            ), requireContext()
        )
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(null, R.id.firstContainer, SecondStory(), binding.root).navigate(
            width,
            activity?.supportFragmentManager
        )
    }

}
