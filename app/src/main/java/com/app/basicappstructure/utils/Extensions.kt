package com.app.basicappstructure.utils

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

class NoInternetException(message: String) : IOException(message)

fun View.liveSnackBar(
    lifecycleOwner: LifecycleOwner,
    snackbarEvent: LiveData<Event<Any?>>,
    timeLength: Int
) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let {
            when (it) {
                is Int -> showAlert(context.getString(it))
                is String -> showAlert(it)
            }

        }
    })
}

fun View.showAlert(message: String?) {
    message?.let { Snackbar.make(this, it, 3000).show() }
}