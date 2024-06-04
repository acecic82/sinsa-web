package com.sinsa.web.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name="hello", url="127.0.0.1:8080")
interface HelloClient {

    @GetMapping(
        "/hello",
        produces = ["application/json"]
    )
    fun hello(): String
}