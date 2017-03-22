package com.example.android.mvpsample.Interactor

import android.text.TextUtils
import android.widget.Toast


/**
 * Created by Artur on 14-Mar-17.
 */
class MainInteractorImpl : MainInteractor {
    override fun runQuery(query: String, listener: MainInteractor.OnQueryFinishedListener) {
        if (TextUtils.isEmpty(query)) {
            listener.onQueryError()
            return
        }
            listener.onSuccess(query)
            return
    }
}