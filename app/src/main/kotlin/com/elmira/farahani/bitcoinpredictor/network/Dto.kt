package com.elmira.farahani.bitcoinpredictor.network

import com.google.gson.annotations.SerializedName

sealed class Dto {

    data class BitcoinHistory(
        @SerializedName("bpi")
        val bpi: Map<String, String>,
        @SerializedName("disclaimer")
        val disclaimer: String,
        @SerializedName("time")
        val time: BitcoinTime
    )

    data class BitcoinTime(
        @SerializedName("updated")
        val updated: String? = "",
        @SerializedName("updatedISO")
        val updatedISO: String? = ""

    )

    data class TimeDto(
        @SerializedName("start")
        val start: String,
        @SerializedName("end")
        val end: String
    )
}