package com.sinsa.web.controller

import com.sinsa.web.client.ProductClient
import com.sinsa.web.common.Converter
import com.sinsa.web.controller.form.BrandForm
import com.sinsa.web.controller.form.CategoryForm
import com.sinsa.web.controller.form.ProductForm
import com.sinsa.web.dto.ProductInfoDTO
import com.sinsa.web.dto.SaveBrandDTO
import com.sinsa.web.exception.BusinessException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@Controller
@RequestMapping("/product")
class ProductController(
    private val productClient: ProductClient
) {

    @GetMapping
    fun main(): String {
        return "main"
    }

    @GetMapping("/lowest/all-category")
    fun findLowestAllCategory(model: Model): String {
        val result = productClient.getLowestPriceAllCategory()

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        model.addAttribute("products", result.content.categoryAndBrandInfoVOList)
        model.addAttribute("totalPrice", result.content.totalPrice)

        return "lowest/category"
    }

    @GetMapping("/lowest/brand")
    fun findLowestSumPriceAllBrand(model: Model): String {
        val result = productClient.getLowestPriceBrand()

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        model.addAttribute("products", result.content)

        return "lowest/brand"
    }

    @GetMapping("/low-high/category")
    fun findLowAndHighCategory(model: Model): String {
        return "lowhigh/selectCategory"
    }

    @PostMapping("/low-high/category")
    fun findLowAndHighCategory(@ModelAttribute categoryForm: CategoryForm, model: Model): String {

        val result = productClient.getLowAndHighCategory(categoryForm.category)

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        model.addAttribute("maxList", result.content.highestBrandList)
        model.addAttribute("minList", result.content.lowestBrandList)

        return "lowhigh/selectCategory"
    }

    @GetMapping("/all")
    fun findAllProduct(model: Model): String {
        val result = productClient.getProductAll()

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        model.addAttribute("list", result.content)

        return "product/all"
    }

    @GetMapping("/save")
    fun goSavePage(): String {
        return  "product/save"
    }

    @PostMapping("/save")
    fun goSavePage(productForm: ProductForm): String {
        val productInfoDTO =
            ProductInfoDTO(null, productForm.category, productForm.brand, BigDecimal(productForm.price))

        val result = productClient.save(productInfoDTO)

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        return  "product/save"
    }

    @PostMapping("/delete")
    fun delete(productForm: ProductForm): String {
        val productInfoDTO =
            ProductInfoDTO(productForm.productId, productForm.category, productForm.brand, BigDecimal(productForm.price))
        val result = productClient.delete(productInfoDTO)

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        return  "redirect:/product/all"
    }

    @GetMapping("/update/{productId}")
    fun update(@PathVariable productId: Long, model: Model): String {

        model.addAttribute("productId", productId)

        return  "product/update"
    }

    @PostMapping("/update")
    fun update(productForm: ProductForm): String {
        val productInfoDTO = ProductInfoDTO(
            productForm.productId, productForm.category, productForm.brand, BigDecimal(productForm.price))

        val result = productClient.update(productInfoDTO)

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        return  "redirect:/product/all"
    }

    @GetMapping("/brand/save")
    fun brandSave(): String {
        return "brand/save"
    }

    @PostMapping("/brand/save")
    fun brandSave(brandForm: BrandForm): String {
        val productList = Converter.brandFormToProductList(brandForm)
        val saveBrandDTO = SaveBrandDTO(brandForm.brand, productList)

        val result = productClient.saveBrand(saveBrandDTO)

        if(result.content == null) {
            throw BusinessException(result.code, result.message)
        }

        return "brand/save"
    }
}