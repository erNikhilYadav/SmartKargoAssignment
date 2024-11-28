package com.futurecraft.smartkargoassignment.data.repository

import com.futurecraft.smartkargoassignment.data.remote.ApiService
import com.futurecraft.smartkargoassignment.data.remote.response.ProductsResponse
import javax.inject.Inject

class ProductsRepository
@Inject
constructor(
    private val service: ApiService
) {
    suspend fun getProducts(): List<ProductsResponse> {
        try {
            val call = service.getProducts()
            return call.body() as List<ProductsResponse>
        } catch (e: Exception) {
            return emptyList()
        }

    }
}