package com.example.android.mvpsample.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.android.mvpsample.BuildConfig
import com.example.android.mvpsample.Presenter.MainPresenterImpl
import com.example.android.mvpsample.R
import com.example.android.mvpsample.View.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {
    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    private var presenter: MainPresenterImpl by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
        searchImg.setOnClickListener(this)
        editText.hint = BuildConfig.API_KEY_PUBLIC
    }

    override fun showProgress() {
        Log.v(TAG,"showProgress triggered")
    }

    override fun hideProgress() {
    }

    override fun setQueryError() {
        Log.v(TAG,"onQueryError triggered")
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View?) {
        Log.v(TAG,"onClick triggered!")
        presenter.validateEntry(editText.text.toString())
    }
}
