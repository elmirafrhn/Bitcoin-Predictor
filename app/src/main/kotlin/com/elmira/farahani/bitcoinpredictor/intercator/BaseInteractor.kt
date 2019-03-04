package com.elmira.bitcoin.bitcoinpredictor.intercator

import com.elmira.bitcoin.bitcoinpredictor.network.IApiService
import javax.inject.Inject

open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) :
    IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}