package com.sinsa.web.controller

import com.sinsa.web.client.HelloClient
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController(
    private val helloClient: HelloClient
) {

    @GetMapping("/hello")
    fun hello(): String {
        val result = helloClient.hello()
        println(result)

        return "hello"
    }
}