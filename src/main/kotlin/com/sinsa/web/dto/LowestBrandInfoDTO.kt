package com.sinsa.web.dto

import com.sinsa.web.vo.CategoryAndPriceVO
import java.math.BigDecimal

data class LowestBrandInfoDTO(
    val brand: String,
    val categoryAndPriceList: List<CategoryAndPriceVO>,
    val totalPrice: BigDecimal
)

