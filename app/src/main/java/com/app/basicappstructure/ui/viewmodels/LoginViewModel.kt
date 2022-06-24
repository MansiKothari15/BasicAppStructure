package com.app.basicappstructure.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.app.basicappstructure.network.PrefProvider
import com.app.basicappstructure.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val repository: AppRepository,
    private val prefProvider: PrefProvider
): ViewModel() {

    fun login(){

    }

}