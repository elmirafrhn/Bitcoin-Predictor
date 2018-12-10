package com.farahani.elmira.bitcoinpredictor

import com.farahani.elmira.bitcoinpredictor.model.BitcoinHistoryModel
import com.farahani.elmira.bitcoinpredictor.network.Dto

fun Dto.BitcoinHistory.map()= BitcoinHistoryModel(
    bpi = bpi
)