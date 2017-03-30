package com.example.android.mvpsample.Presenter

import android.widget.Toast
import com.example.android.mvpsample.View.MainView
import com.example.android.mvpsample.Interactor.MainInteractor
import com.example.android.mvpsample.Interactor.MainInteractorImpl
import java.util.*
import kotlin.properties.Delegates

class MainPresenterImpl(private var mainView: MainView) : MainPresenter, MainInteractor.OnQueryFinishedListener {

    private val mainInteractor: MainInteractor

    init {
        this.mainInteractor = MainInteractorImpl()
    }


    override fun validateEntry(entry: String) {
        mainView.showProgress()
        mainInteractor.runQuery(entry, this)
    }

    override fun onQueryError() {
        with(mainView) {
            hideProgress()
            setQueryError()
        }
    }

    override fun onSuccess(message: String) {
        mainView.showMessage(message)
    }
}