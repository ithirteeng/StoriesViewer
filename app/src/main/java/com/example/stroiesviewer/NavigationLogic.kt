package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.navigation.NavController

class NavigationLogic(
    private val firstFragment: Int?,
    private val secondFragment: Int?,
    private val root: View
) {

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    fun navigate(width: Int?, navController: NavController) {
        root.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val x = event.rawX
                    if (this.firstFragment == null) {
                        if (x >= width!! / 2) {
                            navController.navigate(secondFragment!!)
                        }
                    } else if (secondFragment == null) {
                        if (x <= width!! / 2) {
                            navController.navigate(firstFragment)
                        }
                    } else {
                        if (x >= width!! / 2) {
                            navController.navigate(secondFragment)
                        } else {
                            navController.navigate(firstFragment)
                        }
                    }
                }
            }
            true
        }
    }
}