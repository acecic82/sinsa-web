package com.sinsa.web.exception

import com.sinsa.web.common.ExceptionCode

class BusinessException(
    val code: ExceptionCode?,
    override val message: String?,
): RuntimeException(message)