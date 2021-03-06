package com.ihorvitruk.telegramclient.presentation.base

import android.support.v7.app.AppCompatActivity
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    private val viewModelStack: Stack<BaseViewModel<*>> = Stack()

    protected fun <VM : BaseViewModel<*>> replaceView(view: BaseView<*, VM>, viewModel: VM) {
        while (viewModelStack.isNotEmpty()) {
            viewModelStack.pop().onDestroy()
        }
        setContentView(view)
        viewModelStack.push(viewModel).onCreate()
    }

    protected fun <VM : BaseViewModel<*>> addView(view: BaseView<*, VM>, viewModel: VM) {
        //TODO implement using FrameLayout#addView
        viewModelStack.push(viewModel).onCreate()
    }
}