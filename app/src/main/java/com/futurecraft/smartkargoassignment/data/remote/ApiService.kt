package com.futurecraft.smartkargoassignment.data.remote

import com.futurecraft.smartkargoassignment.constants.Constants.PRODUCTS_ENDPOINT
import com.futurecraft.smartkargoassignment.data.remote.response.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(PRODUCTS_ENDPOINT)
    suspend fun getProducts(): Response<List<ProductsResponse>>

}