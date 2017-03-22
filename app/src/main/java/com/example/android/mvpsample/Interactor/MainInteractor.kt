package com.example.android.mvpsample.Interactor

/**
 * Created by Artur on 14-Mar-17.
 */
interface MainInteractor {

    interface OnQueryFinishedListener {
        fun onQueryError()
        fun onSuccess(message: String)
    }

    fun runQuery(query: String, listener: OnQueryFinishedListener)
}