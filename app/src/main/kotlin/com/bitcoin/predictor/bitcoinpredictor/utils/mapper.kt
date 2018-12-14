package com.bitcoin.predictor.bitcoinpredictor.utils

import com.bitcoin.predictor.bitcoinpredictor.model.BitcoinHistoryModel
import com.bitcoin.predictor.bitcoinpredictor.network.Dto

fun Dto.BitcoinHistory.map()=
    BitcoinHistoryModel(
        bpi = bpi.toString()
            .replace("{", "")
            .replace("}", "")
            .split(",").map {
                it.split("=")[1].toDouble()
            }
    )