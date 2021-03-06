package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.stroiesviewer.databinding.FragmentFourthStoryBinding

class FourthStory : Fragment() {
    private lateinit var binding: FragmentFourthStoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthStoryBinding.inflate(layoutInflater)
        changeData()
        toAnotherFragments()

        binding.container.button.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(this.resources.getString(R.string.mexicoSource)))
            startActivity(browserIntent)
        }

        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "NewApi")
    private fun changeData() {
        val changeStoriesData = ChangeStoriesData(binding.container)
        changeStoriesData.changePlaceText("Мехико, Мексика")
        changeStoriesData.changeTimeText("3 - 10 Мая")
        changeStoriesData.changeHeaderText("Улицы")
        changeStoriesData.changeDescriptionText("Подборка для вас")
        changeStoriesData.changeMainPicture(
            resources.getDrawable(
                R.drawable.mexico_pictures,
                requireContext().theme
            )
        )
        changeStoriesData.makeImage(
            resources.getDrawable(
                R.drawable.mexico_pictures,
                requireContext().theme
            ), requireContext()
        )
        changeStoriesData.updateView(3, requireContext())
    }

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    private fun toAnotherFragments() {
        val width = activity?.windowManager?.defaultDisplay?.width
        NavigationLogic(ThirdStory(), R.id.fourthContainer, FifthStory(), binding.root).navigate(
            width,
            activity?.supportFragmentManager
        )
    }
}