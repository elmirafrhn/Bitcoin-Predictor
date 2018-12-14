package com.bitcoin.predictor.bitcoinpredictor.intercator

import com.bitcoin.predictor.bitcoinpredictor.network.IApiService
import javax.inject.Inject

open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) :
    IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}