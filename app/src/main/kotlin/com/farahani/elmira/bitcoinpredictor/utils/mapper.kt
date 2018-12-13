package com.farahani.elmira.bitcoinpredictor.utils

import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import com.farahani.elmira.bitcoinpredictor.network.Dto

fun Dto.BitcoinHistory.map()= BitcoinHistoryModel(
    bpi = bpi.toString()
        .replace("{", "")
        .replace("}", "")
        .split(",").map {
            it.split("=")[1].toDouble()
        }
)