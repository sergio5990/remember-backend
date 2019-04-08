package com.github.sergio5990.ellipse.core

class ApiResponse<T : Any>(val body: T?,
                           val errors: List<ApiError>) {
    val isSuccess = errors.isEmpty()
    val isError = errors.isNotEmpty()

    fun unwrap() = if (isSuccess) body else null
}

fun <T : Any> ok(body: T) = ApiResponse(body, listOf())

fun <T : Any> errors(errors: List<ApiError>): ApiResponse<T> {
    return ApiResponse(null, errors) as ApiResponse<T>
}

fun <T : Any> error(error: ApiError): ApiResponse<T> {
    return ApiResponse(null, listOf(error)) as ApiResponse<T>
}


class ApiError(val message: String,
               val subject: Any? = null,
               val type: String? = null)

fun errors(message: String) = listOf(ApiError(message))
fun errors() = listOf<ApiError>()
fun error(message: String, type: String) = ApiError(message = message, type = type)
fun error(message: String, subject: Any, type: String) = ApiError(message, subject, type)

fun error(exception: Throwable) = ApiError(exception.message
        ?: exception.javaClass.canonicalName)

