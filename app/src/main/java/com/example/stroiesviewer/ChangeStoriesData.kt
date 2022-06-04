package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.stroiesviewer.databinding.TemplateForFragmentsBinding
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.max


class ChangeStoriesData(binding: TemplateForFragmentsBinding) {
    companion object {
        const val BITMAP_SCALE = 0.4f
    }

    private val binding = binding
    private val storyViews = arrayListOf<ImageView>(
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
    }

    fun changeBackgroundPicture(context: Context, view: View) {
    }

    private fun imageMatrix() {
        val matrix = binding.blurImage.imageMatrix
    }

    private fun createBlurEffect(imageView: ImageView) {
        var matrix = imageView.imageMatrix
        val radius = 11
        var sigma = max((radius / 2).toDouble(), 1.0)
        var kernelWidth = (2 * radius) + 1
        var kernel = ArrayList<ArrayList<Double>>()
        for (i in 0 until kernelWidth) {
            kernel.add(ArrayList())
            for (j in 0 until kernelWidth) {
                kernel[i].add(0.0)
            }
        }
        var sum = 0.0

        for (x in -radius..radius) {
            for (y in -radius..radius) {
                val exPNum = -(x * x + y * y).toDouble()
                val expDenominator = (2 * sigma * sigma)

                val eExpression = exp(exPNum / expDenominator)
                val kernelValue = (eExpression / (2 * PI * sigma * sigma))

                kernel[x + radius][y + radius] = kernelValue
                sum += kernelValue
            }

        }

        for (x in 0 until kernelWidth) {
            for (y in 0 until  kernelWidth) {
                kernel[x][y] /= sum
            }
        }





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