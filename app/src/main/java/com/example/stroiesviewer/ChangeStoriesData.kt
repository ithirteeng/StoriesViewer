package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.stroiesviewer.databinding.TemplateForFragmentsBinding


class ChangeStoriesData(private val binding: TemplateForFragmentsBinding) {
    private val storyViews = arrayListOf(
        binding.firstStoryView,
        binding.secondStoryView,
        binding.thirdStoryView,
        binding.fourthStoryView,
        binding.fifthStoryView,
    )

    fun changePlaceText(string: String) {
        binding.placeTextView.text = string
    }

    @SuppressLint("SetTextI18n")
    fun changeTimeText(string: String) {
        binding.timeTextView.text = string
    }

    fun changeHeaderText(string: String) {
        binding.headerTextView.text = string
    }

    fun changeDescriptionText(string: String) {
        binding.descriptionTextView.text = string
    }

    fun changeButtonOutsource(string: String) {
        TODO()
    }

    fun changeMainPicture(imageResource: Drawable) {
        binding.mainImage.setImageDrawable(imageResource)
        binding.blurImage.setImageDrawable(imageResource)
        binding.blurImage.setColorFilter(Color.argb(100, 0, 0, 0))
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun updateView(index: Int, context: Context) {
        for (image in storyViews) {
            if (image == storyViews[index]) {
                image.setImageDrawable(
                    context.resources.getDrawable(
                        R.drawable.current_story_line,
                        context.theme
                    )
                )
            } else {
                image.setImageDrawable(
                    context.resources.getDrawable(
                        R.drawable.empty_story_line,
                        context.theme
                    )
                )
            }
        }
    }


}