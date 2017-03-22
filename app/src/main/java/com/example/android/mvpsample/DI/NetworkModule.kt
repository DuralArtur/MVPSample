package com.example.android.mvpsample.DI

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Artur on 15-Mar-17.
 */

@Module
        class NetworkModule(){
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
                .baseUrl("http://gowno.pl")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}