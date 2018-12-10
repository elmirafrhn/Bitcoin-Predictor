package com.farahani.elmira.bitcoinpredictor.di

import com.farahani.elmira.bitcoinpredictor.network.ApiService
import com.farahani.elmira.bitcoinpredictor.network.ApiUtils
import com.farahani.elmira.bitcoinpredictor.network.IApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
abstract class NetworkModule {

    @Module
    companion object {

        @Provides
        @Reusable
        @JvmStatic
        internal fun provideRetrofitApiService(retrofit: Retrofit): IApiService {
            return retrofit.create(IApiService::class.java)
        }

        @Provides
        @Reusable
        @JvmStatic
        internal fun provideRetrofitInterface(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        }

        @Provides
        @Singleton
        internal fun provideApiService(apiService: ApiService): IApiService {
            return apiService
        }
    }
}