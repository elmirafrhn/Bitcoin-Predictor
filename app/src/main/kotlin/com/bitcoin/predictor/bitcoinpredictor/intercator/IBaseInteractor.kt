package com.bitcoin.predictor.bitcoinpredictor.intercator

import com.bitcoin.predictor.bitcoinpredictor.network.IApiService

interface IBaseInteractor {
    fun getApiService(): IApiService
}