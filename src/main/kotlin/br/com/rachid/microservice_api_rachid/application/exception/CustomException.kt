package br.com.rachid.microservice_api_rachid.application.exception

import org.springframework.http.HttpStatus

class CustomException(
        var statusCode: HttpStatus? = HttpStatus.INTERNAL_SERVER_ERROR,
        override var message: String? = null
) : Exception(message)
