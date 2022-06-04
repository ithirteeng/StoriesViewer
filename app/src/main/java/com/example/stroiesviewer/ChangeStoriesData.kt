package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.renderscript.Allocation.createFromBitmap
import com.example.stroiesviewer.databinding.TemplateForFragmentsBinding
import kotlin.math.roundToInt

class ChangeStoriesData(binding: TemplateForFragmentsBinding) {
    companion object {
        const val BITMAP_SCALE = 0.4f
    }
    private val binding = binding
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
    }

    fun makeBlurForBackgroundPicture(imageView: ImageView) {

    }

    private fun blur(context: Context, image: Bitmap) : Bitmap {

        val width = (image.width * BITMAP_SCALE).roundToInt()
        val height = (image.height * BITMAP_SCALE).roundToInt()

        var inputBitmap = Bitmap.createScaledBitmap(image, width, height, false)
        var outputBitmap = Bitmap.createFromBitmap(inputBitmap)
    }
}