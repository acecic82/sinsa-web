package com.sinsa.web.dto

import com.sinsa.web.vo.ProductInfoVO
import java.math.BigDecimal

data class LowestCategoryInfoDTO(
    val categoryAndBrandInfoVOList: List<ProductInfoVO>,
    val totalPrice: BigDecimal
)
