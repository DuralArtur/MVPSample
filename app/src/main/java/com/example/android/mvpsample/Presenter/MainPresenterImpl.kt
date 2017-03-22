package com.example.android.mvpsample.Presenter

import android.widget.Toast
import com.example.android.mvpsample.View.MainView
import com.example.android.mvpsample.Interactor.MainInteractor
import com.example.android.mvpsample.Interactor.MainInteractorImpl
import kotlin.properties.Delegates

/**
 * Created by Artur on 14-Mar-17.
 */
class MainPresenterImpl(private var mainView: MainView) : MainPresenter, MainInteractor.OnQueryFinishedListener {

    private val mainInteractor: MainInteractor

    init {
        this.mainInteractor = MainInteractorImpl()
    }


    override fun validateEntry(entry: String) {
        mainView.showProgress()
        mainInteractor.runQuery(entry,this)
    }

    override fun onQueryError() {
        mainView.setQueryError()
    }

    override fun onSuccess(message: String) {
        mainView.showMessage(message)
    }
}