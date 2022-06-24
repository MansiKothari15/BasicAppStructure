package com.app.basicappstructure.network

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) : BaseDataSource() {

    suspend fun userLogIn(data: HashMap<String, String>) = getResult { apiService.userLogIn(data) }

    suspend fun userSignUp(data: HashMap<String, String>) = getResult { apiService.userSignUp(data) }

}