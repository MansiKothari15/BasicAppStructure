package com.app.basicappstructure.network
import com.app.basicappstructure.data.response.LoginResponse
import com.app.basicappstructure.data.response.SignUpResponse
import com.app.basicappstructure.network.Constants.USERS_LOG_IN
import com.app.basicappstructure.network.Constants.USERS_SIGN_UP
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(USERS_LOG_IN)
    suspend fun userLogIn(@FieldMap options: HashMap<String, String>): LoginResponse

    @FormUrlEncoded
    @POST(USERS_SIGN_UP)
    suspend fun userSignUp(@FieldMap options: HashMap<String, String>): SignUpResponse

}