package com.elmira.farahani.bitcoinpredictor.utils

import com.elmira.farahani.bitcoinpredictor.model.BitcoinHistoryModel
import com.elmira.farahani.bitcoinpredictor.network.Dto

fun Dto.BitcoinHistory.map()=
    BitcoinHistoryModel(
        bpi = bpi.toString()
            .replace("{", "")
            .replace("}", "")
            .split(",").map {
                it.split("=")[1].toDouble()
            }
    )