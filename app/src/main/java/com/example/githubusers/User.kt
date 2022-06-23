package com.example.githubusers

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var username: String,
    var photo: Int,
    var location: String,
    var flag: String,
    var followers: String,
    var following: String,
    var repository: String
) : Parcelable
