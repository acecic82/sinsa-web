package com.sinsa.web.vo

import java.math.BigDecimal

data class ProductInfoVO(
    val productId: Long?,
    val category: String,
    val brand: String,
    val price: BigDecimal
)
