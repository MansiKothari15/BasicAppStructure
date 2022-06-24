package com.app.basicappstructure.repository

import com.app.basicappstructure.network.ApiHelper
import com.app.basicappstructure.network.PrefProvider
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val prefProvider: PrefProvider,
    private val apiHelperNew: ApiHelper
)
{
    suspend fun userLogIn(data: HashMap<String, String>) = apiHelperNew.userLogIn(data)

    suspend fun userSignUp(data: HashMap<String, String>) = apiHelperNew.userSignUp(data)
}