package com.app.basicappstructure.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.basicappstructure.data.model.LoginRequestModel
import com.app.basicappstructure.data.response.LoginResponse
import com.app.basicappstructure.network.PrefProvider
import com.app.basicappstructure.repository.AppRepository
import com.app.basicappstructure.utils.Event
import com.app.basicappstructure.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val repository: AppRepository,
    private val prefProvider: PrefProvider
): ViewModel() {

    val loginDetails = MutableLiveData(LoginRequestModel())

    private val _snackbarText = MutableLiveData<Event<Any?>>()
    val snackbarText: LiveData<Event<Any?>> = _snackbarText

    private val _showProgress = MutableLiveData<Event<Boolean>>()
    val showProgress: LiveData<Event<Boolean>> = _showProgress

    private val _data = MutableLiveData<Event<LoginResponse?>>()
    val data: LiveData<Event<LoginResponse?>> = _data

    fun login(){
        val data = HashMap<String, String>()
        data["username"] = loginDetails.value?.emailAddress.toString().trim()
        data["password"] = loginDetails.value?.password.toString().trim()

        viewModelScope.launch {
            val resource = repository.userLogIn(data)
            when (resource.status) {
                Status.SUCCESS -> {
                    _showProgress.value = Event(false)
                    resource.data.let { logInResponse ->
                        _data.value = Event(logInResponse)
                    }
                }

                Status.ERROR -> {
                    _snackbarText.value = Event(resource.message)
                    _showProgress.value = Event(false)
                }

                Status.LOADING -> {
                    _showProgress.value = Event(true)
                }
            }
        }

    }

}