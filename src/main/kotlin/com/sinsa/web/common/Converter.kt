package com.sinsa.web.common

import com.sinsa.web.controller.form.BrandForm
import com.sinsa.web.dto.ProductInfoDTO
import java.math.BigDecimal


//구조가 정말 마음에 안들지만 급하게 만드느라 이렇게 만들었습니다.
object Converter {
    fun brandFormToProductList(brandForm: BrandForm): List<ProductInfoDTO> {
        val list = mutableListOf<ProductInfoDTO>()
        val brand = brandForm.brand

        list.addLast(
            ProductInfoDTO(
                null,
                category = "상의",
                brand = brand,
                price = BigDecimal(brandForm.shirts)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "아우터",
                brand = brand,
                price = BigDecimal(brandForm.outer)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "바지",
                brand = brand,
                price = BigDecimal(brandForm.pants)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "스니커즈",
                brand = brand,
                price = BigDecimal(brandForm.sneakers)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "가방",
                brand = brand,
                price = BigDecimal(brandForm.bag)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "모자",
                brand = brand,
                price = BigDecimal(brandForm.cap)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "양말",
                brand = brand,
                price = BigDecimal(brandForm.shocks)
            )
        )

        list.addLast(
            ProductInfoDTO(
                null,
                category = "액세서리",
                brand = brand,
                price = BigDecimal(brandForm.accessories)
            )
        )

        return list
    }
}