package com.example.myapk

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
