package com.example.myapplication.ui

import com.example.myapplication.R

enum class AppDestinations(val label: Int, val icon: Int, val contentDescription: Int) {
    HOME(R.string.home, R.drawable.ic_home, R.string.home),
    FAVORITES(R.string.favorites, R.drawable.ic_favorite, R.string.favorites),
    PROFILE(R.string.profile, R.drawable.ic_account_box, R.string.profile)
}