package com.example.innstantbook.networking.model

data class NetworkingError(
    override val message: String?,
    val errorCode: String? = null,
    val errorDescription: String? = null,
    val httpCode: Int? = null,
    val httpErrorDescription: String? = null,
    val originalError: Throwable? = null,
    val errorBody: String? = null,
    val errorTitle: String? = null
) : BaseNetworkError() {

    constructor(
        message: String?,
        errorCode: String? = null,
        errorDescription: String? = null,
        httpCode: Int? = null,
        httpErrorDescription: String? = null,
        originalError: Throwable? = null
    ) : this(
        message = message,
        errorCode = errorCode,
        errorDescription = errorDescription,
        httpCode = httpCode,
        httpErrorDescription = httpErrorDescription,
        originalError = originalError,
        errorBody = null
    )

    constructor(
        message: String?,
        errorCode: String? = null,
        errorDescription: String? = null,
        httpCode: Int? = null,
        httpErrorDescription: String? = null,
        originalError: Throwable? = null,
        errorBody: String? = null,
    ) : this(
        message = message,
        errorCode = errorCode,
        errorDescription = errorDescription,
        httpCode = httpCode,
        httpErrorDescription = httpErrorDescription,
        originalError = originalError,
        errorBody = errorBody,
        errorTitle = null
    )
}

open class BaseNetworkError : Throwable() {
    open val httpErrorCode: Int? = 0
}