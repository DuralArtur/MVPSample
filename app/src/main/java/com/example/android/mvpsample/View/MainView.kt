package com.example.android.mvpsample.View

/**
 * Created by Artur on 14-Mar-17.
 */
interface MainView {
    fun showProgress()
    fun hideProgress()
    fun setQueryError()
    fun showMessage(message:String)
}