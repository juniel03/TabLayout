package com.bluesolution.tablayout.data.menu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val discountRate: String,
    val ex: String,
    val imgPath: List<String>,
    val max_count: String,
    val menu_ctg_name: String,
    val menu_sttus_code: Int,
    val name: String,
    val orignPrice: String,
    val poption: List<Poption>,
    val price: String
):Parcelable