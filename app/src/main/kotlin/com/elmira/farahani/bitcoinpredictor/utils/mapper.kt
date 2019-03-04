package com.elmira.bitcoin.bitcoinpredictor.utils

import com.elmira.bitcoin.bitcoinpredictor.model.BitcoinHistoryModel
import com.elmira.bitcoin.bitcoinpredictor.network.Dto

fun Dto.BitcoinHistory.map()=
    BitcoinHistoryModel(
        bpi = bpi.toString()
            .replace("{", "")
            .replace("}", "")
            .split(",").map {
                it.split("=")[1].toDouble()
            }
    )