package com.sinsa.web.controller.form

data class ProductForm(
    val productId: Long? = null,
    val category: String,
    val brand: String,
    val price: String
)
