package com.bluesolution.tablayout.data.live

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val discountRate: String,
    val ex: String,
    val img: List<String>,
    val key: String,
    val name: String,
    val orignPrice: String,
    val price: String,
    val status: String,
    val top: String
):Parcelable