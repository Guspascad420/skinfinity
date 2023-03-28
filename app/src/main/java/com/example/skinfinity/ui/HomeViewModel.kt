package com.example.skinfinity.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.skinfinity.R
import com.example.skinfinity.data.Todo
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*

class HomeViewModel : ViewModel() {
    var dayIcon by mutableStateOf(R.drawable.fa6_solid_cloud_moon)
    val todoLists = listOf(
        Todo("Judul To do list", "Lorem ipsum dolor sit amet consectetur. " +
                "Risus sodales posuere sagittis sed blandit id accumsan.",
            LocalTime.parse("07:00:00"), true),
        Todo("Judul To do list", "Lorem ipsum dolor sit amet consectetur. " +
                "Risus sodales posuere sagittis sed blandit id accumsan.",
            LocalTime.parse("13:00:00"), false),
        Todo("Judul To do list", "Lorem ipsum dolor sit amet consectetur. " +
                "Risus sodales posuere sagittis sed blandit id accumsan.",
            LocalTime.parse("19:00:00"), false)
    )
    val newsImage = listOf(
        R.drawable.rectangle_32, R.drawable.rectangle_33,
        R.drawable.rectangle_34, R.drawable.rectangle_35
    )

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

class AppScreenIcon(
    val name: String,
    val iconId: Int,
    val activeIconId: Int = 0,
    val onClick: () -> Unit = { }
)

fun getCurrentDay(): String {
    val sdf = SimpleDateFormat("EEEE")
    val d = Date()
    return sdf.format(d)
}