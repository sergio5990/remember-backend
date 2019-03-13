package com.github.sergio5990.remember.dsl.core.gateway

class ApiError(val message: String,
               val subject: Any? = null,
               val type: String? = null)

fun error(message: String) = ApiError(message)
fun errors(message: String) = listOf(ApiError(message))
fun errors() = listOf<ApiError>()
fun error(message: String, type: String) = ApiError(message = message, type = type)
fun error(message: String, subject: Any, type: String) = ApiError(message, subject, type)
fun error(exception: Throwable) = ApiError(exception.message ?: exception.javaClass.canonicalName)

class ApiResponse<T : Any>(val body: T?,
                           val errors: List<ApiError>) {
  val isSuccess = errors.isEmpty()
  val isError = errors.isNotEmpty()

  fun unwrap() = if (isSuccess) body else null
}

fun response(errors: List<ApiError>) = ApiResponse(null, errors)
fun response(error: ApiError) = ApiResponse(null, listOf(error))
fun <T : Any> response(body: T) = ApiResponse(body, listOf())