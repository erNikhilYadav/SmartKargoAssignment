package com.futurecraft.smartkargoassignment.data.di

import com.futurecraft.smartkargoassignment.data.remote.ApiService
import com.futurecraft.smartkargoassignment.data.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit.Builder): ApiService =
        retrofit.build().create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideProductsRepository(
        apiService: ApiService
    ): ProductsRepository = ProductsRepository(apiService)
}