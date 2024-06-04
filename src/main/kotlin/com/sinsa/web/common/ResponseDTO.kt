package com.sinsa.web.common

data class ResponseDTO<T>(
    val isSuccess: String? = null,
    val content: T? = null,
    val code: ExceptionCode? = null,
    val message: String? = null
)