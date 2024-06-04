package com.sinsa.web.exception

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvicer {

    @ExceptionHandler(value = [BusinessException::class])
    fun businessException(e: BusinessException, model: Model): String {
        println(e.message)
        model.addAttribute("message", e.message)
        return "errorAlert"
    }

    @ExceptionHandler(value = [Exception::class])
    fun exception(e: Exception, model: Model): String {
        println(e.message)
        model.addAttribute("message", e.message)
        return "errorAlert"
    }
}