package com.bluesolution.tablayout.data.live

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LiveModel(
    val data: List<Data>
):Parcelable