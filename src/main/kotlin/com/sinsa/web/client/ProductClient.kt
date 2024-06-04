package com.sinsa.web.client

import com.sinsa.web.common.ResponseDTO
import com.sinsa.web.dto.LowHighBrandInfoDTO
import com.sinsa.web.dto.LowestBrandInfoDTO
import com.sinsa.web.dto.LowestCategoryInfoDTO
import com.sinsa.web.dto.ProductInfoDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name="product", url="127.0.0.1:8080")
interface ProductClient {

    @GetMapping(
        "/product/lowest/all-category",
        produces = ["application/json"]
    )
    fun getLowestPriceAllCategory(): ResponseDTO<LowestCategoryInfoDTO>

    @GetMapping(
        "/product/lowest/brand",
        produces = ["application/json"]
    )
    fun getLowestPriceBrand(): ResponseDTO<List<LowestBrandInfoDTO>>

    @GetMapping(
        "/product/low-high/brand/{category}",
        produces = ["application/json"]
    )
    fun getLowAndHighCategory(@PathVariable category: String): ResponseDTO<LowHighBrandInfoDTO>

    @GetMapping(
        "/product/all",
        produces = ["application/json"]
    )
    fun getProductAll(): ResponseDTO<List<ProductInfoDTO>>

    @PostMapping(
        "/product/save",
        produces = ["application/json"]
    )
    fun save(@RequestBody productInfoDTO: ProductInfoDTO): ResponseDTO<Boolean>

    @DeleteMapping(
        "/product/delete",
        produces = ["application/json"]
    )
    fun delete(@RequestBody productInfoDTO: ProductInfoDTO): ResponseDTO<Boolean>

    @PutMapping(
        "/product/update",
        produces = ["application/json"]
    )
    fun update(@RequestBody productInfoDTO: ProductInfoDTO): ResponseDTO<Boolean>
}