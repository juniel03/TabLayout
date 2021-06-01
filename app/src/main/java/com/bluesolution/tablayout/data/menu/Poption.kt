package com.bluesolution.tablayout.data.menu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Poption(
    val adult_yn: String,
    val group: String,
    val key: String,
    val musy_yn: String,
    val origin: String,
    val price: String,
    val value: String
):Parcelable