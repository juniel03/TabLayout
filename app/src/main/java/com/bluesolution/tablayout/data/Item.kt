package com.bluesolution.tablayout.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val description: String,
    val image: String,
    val title: String
): Parcelable