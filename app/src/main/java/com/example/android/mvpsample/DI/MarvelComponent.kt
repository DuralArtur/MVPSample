package com.example.android.mvpsample.DI

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Artur on 15-Mar-17.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NetworkModule::class,
        MarvelModule::class
))
interface MarvelComponent {
    fun inject()
}