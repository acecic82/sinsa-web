package com.sinsa.web.dto

import java.math.BigDecimal

data class ProductInfoDTO (
    val productId: Long? = null,
    val category: String,
    val brand: String,
    val price: BigDecimal
)
