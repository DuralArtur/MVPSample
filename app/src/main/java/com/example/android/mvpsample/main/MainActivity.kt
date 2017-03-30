package com.example.android.mvpsample.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.android.mvpsample.Presenter.MainPresenterImpl
import com.example.android.mvpsample.R
import com.example.android.mvpsample.View.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.ctx
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {
    companion object{
        val TAG: String = MainActivity::class.java.simpleName
        val LAG: Long = 1500
    }

    private var presenter: MainPresenterImpl by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenterImpl(this)
        button.setOnClickListener(this)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setQueryError() {
        Toast.makeText(ctx,resources.getString(R.string.empty),Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        val timer: Timer = Timer()
        timer.schedule(object:TimerTask(){
            override fun run() {
                runOnUiThread { hideProgress()
                    Toast.makeText(ctx,message,Toast.LENGTH_SHORT).show() }
            }
        }, LAG)
    }

    override fun onClick(view: View?) {
        presenter.validateEntry(editText.text.toString())
    }
}
