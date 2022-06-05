package com.example.stroiesviewer

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NavigationLogic(
    private val firstFragment: Fragment?,
    private val currentFragment: Int,
    private val secondFragment: Fragment?,
    private val root: View
) {

    @SuppressLint("ClickableViewAccessibility", "NewApi")
    fun navigate(width: Int?, fragmentManager: FragmentManager?) {
        val transaction = fragmentManager?.beginTransaction()
        root.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val x = event.rawX
                    if (this.firstFragment == null) {
                        if (x >= width!! / 2) {
                            transaction?.replace(currentFragment, secondFragment!!)
                            transaction?.commit()
                        }
                    } else if (secondFragment == null) {
                        if (x <= width!! / 2) {
                            transaction?.replace(currentFragment, firstFragment)
                            transaction?.commit()
                        }
                    } else {
                        if (x >= width!! / 2) {
                            transaction?.replace(currentFragment, secondFragment)
                            transaction?.commit()
                        } else {
                            transaction?.replace(currentFragment, firstFragment)
                            transaction?.commit()
                        }
                    }
                }
            }
            true
        }
    }
}