package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        binding.container.button.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.resources.getString(R.string.moscowSource)))
            startActivity(browserIntent)
        }
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
        changeStoriesData.makeImage(
            resources.getDrawable(
                R.drawable.moscow_picture,
                requireContext().theme
            ), requireContext()
        )
        changeStoriesData.updateView(4, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(FourthStory(), R.id.fifthContainer, null, binding.root).navigate(
            width,
            activity?.supportFragmentManager
        )
    }
}