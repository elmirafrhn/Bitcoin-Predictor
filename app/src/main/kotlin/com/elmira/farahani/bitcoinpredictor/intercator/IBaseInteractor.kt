package com.elmira.bitcoin.bitcoinpredictor.intercator

import com.elmira.bitcoin.bitcoinpredictor.network.IApiService

interface IBaseInteractor {
    fun getApiService(): IApiService
}