package com.bluesolution.tablayout.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Menu(
    val Category: String,
    val items: List<Item>
): Parcelable