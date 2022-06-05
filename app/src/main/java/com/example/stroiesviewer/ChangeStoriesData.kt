package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.stroiesviewer.databinding.TemplateForFragmentsBinding
import jp.wasabeef.blurry.Blurry


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

    fun makeImage(drawable: Drawable, context: Context) {
        //binding.mainImage.setImageDrawable(BitmapDrawable(context.resources, toBitmap(drawable)))
//        binding.blurImage.scaleType = ImageView.ScaleType.FIT_CENTER
        Blurry.with(context).radius(15).sampling(8).from(toBitmap(drawable)).into(binding.blurImage)
        //Blurry.with(context).radius(20).from(toBitmap(drawable)).into(binding.mainImage)
        binding.blurImage.scaleType = ImageView.ScaleType.FIT_XY
    }


    //    fun makeBlur(drawable: Drawable, context: Context) {
//        val bitmap = createBitmap(toBitmap(drawable), context)
//        val dr = BitmapDrawable(context.resources, bitmap)
//        binding.
//    }
//
    private fun toBitmap(drawable: Drawable): Bitmap {
        return (drawable as BitmapDrawable).bitmap
    }
//
//    private fun createBitmap(src: Bitmap, context: Context) : Bitmap {
//        val radius = 11f
//
//        val bitmap = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
//        val renderScript = RenderScript.create(context)
//
//        val blurInput = Allocation.createFromBitmap(renderScript, src)
//        val blurOutput = Allocation.createFromBitmap(renderScript, bitmap)
//        val blur = ScriptIntrinsicBlur.create(renderScript, android.renderscript.Element.U8_4(renderScript))
//
//        blur.setInput(blurInput)
//        blur.setRadius(radius)
//        blur.forEach(blurOutput)
//
//        blurOutput.copyTo(bitmap)
//        renderScript.destroy()
//
//        return bitmap
//    }


//    fun convertToBlur(d: Drawable, context: Context) {
//        val image = makeBlur(imageToBitmap(d))
//        val drawable = BitmapDrawable(context.resources, image)
//        val directory = Environment.getExternalStorageDirectory().toString()
//        var file = File(directory, "my_file.JPEG")
//        val outStream = FileOutputStream(file)
//        image.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
//        outStream.close()
//
//       // binding.mainImage.setImageDrawable(drawable)
//    }
//
//    private fun imageToBitmap(d: Drawable): Bitmap {
//        val drawable = d as BitmapDrawable
//        return drawable.bitmap
//    }
//
//    @SuppressLint("NewApi")
//    private fun makeBlur(bitmap: Bitmap) : Bitmap {
//        val radius = 10
//        val sigma = max((radius / 2).toDouble(), 1.0)
//        val kernelWidth = (2 * radius) + 1
//
//        val kernel = ArrayList<ArrayList<Double>>()
//        for (i in 0 until kernelWidth) {
//            kernel.add(ArrayList())
//            for (j in 0 until kernelWidth) {
//                kernel[i].add(0.0)
//            }
//        }
//        var myBitmap = bitmap
//        myBitmap = myBitmap.copy(Bitmap.Config.ARGB_8888, true)
//        var sum = 0.0
//
//        for (x in -radius..radius) {
//            for (y in -radius..radius) {
//                val expNumber = -(x * x + y * y).toDouble()
//                val expDenominator = (2 * sigma * sigma)
//
//                val eExpression = exp(expNumber/ expDenominator)
//                val kernelValue = (eExpression / (2 * PI * sigma * sigma))
//
//                kernel[x + radius][y + radius] = kernelValue
//                sum += kernelValue
//            }
//        }
//
//        for (x in 0 until kernelWidth) {
//            for (y in 0 until kernelWidth) {
//                kernel[x][y] /= sum
//            }
//        }
//
//        for (x in radius until bitmap.width - radius) {
//            for (y in radius until bitmap.height - radius) {
//                var redValue = 0.0
//                var greenValue = 0.0
//                var blueValue = 0.0
//
//                for (i in -radius..radius) {
//                    for (j in -radius..radius) {
//                        val kernelValue = kernel[i + radius][j + radius]
//
//                        val pixel = bitmap.getPixel(x - i, y - i)
//                        redValue += Color.red(pixel) * kernelValue
//                        greenValue += Color.green(pixel) * kernelValue
//                        blueValue += Color.blue(pixel) * kernelValue
//                    }
//                }
//
//                val newPixel = Color.argb(255f, blueValue.toFloat(), redValue.toFloat() , greenValue.toFloat())
//                myBitmap.set(x, y, newPixel)
//            }
//        }
//
//       return myBitmap
//
//    }


}