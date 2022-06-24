package com.app.basicappstructure.di

import com.app.basicappstructure.network.ApiService
import com.app.basicappstructure.BuildConfig
import com.app.basicappstructure.network.Constants.AUTH_TOKEN
import com.app.basicappstructure.network.Constants.BASE_URL_NEW
import com.app.basicappstructure.network.PrefProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    // private const val BASE_URL = "https://possoft.io/api/v1/"
    public const val BASE_URL = "https://panchsoft.com/development/"  // for BOLD POS

    /*@Singleton
    @Provides
    fun provideNetworkConnectionInterceptor(
        @ApplicationContext app: Context
    ) = NetworkConnectionInterceptor(app)*/


   /* @Provides
    @Singleton
    fun provideHostSelectionInterceptor(preferenceHelper: PrefProvider): HostSelectionInterceptor {
        return HostSelectionInterceptor(preferenceHelper)
    }*/

    @Provides
    fun getRetrofit(
        prefProvider: PrefProvider,

        ): ApiService =
        Retrofit.Builder()
            .baseUrl(prefProvider.getValue(BASE_URL_NEW, BASE_URL))
            .client(
                OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS)
                    .addInterceptor { chain ->
                        chain.proceed(chain.request().newBuilder().also {
                            val authToken = prefProvider.getValue(AUTH_TOKEN, "")
                            println("authToken ::  $authToken")
                            println("BASE_URL :: ${prefProvider.getValue(BASE_URL_NEW, BASE_URL)}")
                            if (authToken.isNotEmpty())
                                it.addHeader("TOKEN", authToken)

                        }.build())
                    }.also { client ->
                        if (BuildConfig.DEBUG) {
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                        }
                    }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}