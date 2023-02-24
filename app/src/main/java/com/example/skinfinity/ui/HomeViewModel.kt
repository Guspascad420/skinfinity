package com.example.skinfinity.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.skinfinity.R
import java.time.LocalTime

class HomeViewModel : ViewModel() {
    var dayIcon by mutableStateOf(R.drawable.fa6_solid_cloud_moon)

    fun dayPartGreeting(): String {
        val time = LocalTime.now()
        val afternoon = LocalTime.parse("12:00:00")
        val night = LocalTime.parse("18:00:00")

        var greeting = ""
        if (time.isAfter(afternoon) && time.isAfter(night)) {
            greeting = "Good Night!"
        } else if (time.isBefore(afternoon)) {
            greeting = "Good Morning!"
        } else if (time.equals(afternoon)) {
            greeting = "Good Afternoon!"
        } else if (time.equals(night)) {
            greeting = "Good Night!"
        } else if (time.isAfter(afternoon)) {
            greeting = "Good Afternoon!"
        }
        return greeting
    }
}