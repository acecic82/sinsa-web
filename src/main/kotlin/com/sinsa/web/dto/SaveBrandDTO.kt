package com.sinsa.web.dto

data class SaveBrandDTO(
    val brand: String,
    val productList: List<ProductInfoDTO>
)
