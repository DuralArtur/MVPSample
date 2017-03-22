package com.example.android.mvpsample.DI

import android.app.Application
import android.content.Context
import com.example.android.mvpsample.MVPSampleApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Artur on 15-Mar-17.
 */
@Module
class AppModule(val app: MVPSampleApp) {

    @Provides
    @Singleton
    fun provideCtx(): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApp(): MVPSampleApp {
        return app
    }

}