package com.sinsa.web.dto

import com.sinsa.web.vo.BrandAndPriceVO

data class LowHighBrandInfoDTO(
    val category: String,
    val lowestBrandList: List<BrandAndPriceVO>,
    val highestBrandList: List<BrandAndPriceVO>
)
