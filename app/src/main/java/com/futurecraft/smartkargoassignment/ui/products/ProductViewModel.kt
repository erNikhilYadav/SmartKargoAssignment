package com.futurecraft.smartkargoassignment.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.futurecraft.smartkargoassignment.data.remote.response.ProductsResponse
import com.futurecraft.smartkargoassignment.data.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<ProductsResponse>?>(emptyList())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _products.value = repository.getProducts()
        }
    }
}
