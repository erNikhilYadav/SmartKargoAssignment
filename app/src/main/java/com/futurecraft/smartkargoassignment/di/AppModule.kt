package com.futurecraft.smartkargoassignment.di

import com.futurecraft.smartkargoassignment.constants.Constants
import com.futurecraft.smartkargoassignment.constants.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClientWithoutHeader(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient =
        with(OkHttpClient.Builder()) {
            addInterceptor(loggingInterceptor)
            connectTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(
        gson: Gson, okHttpClient: OkHttpClient
    ): Retrofit.Builder =
        Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            )

}