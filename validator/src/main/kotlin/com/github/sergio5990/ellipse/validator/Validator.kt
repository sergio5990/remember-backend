interface Validator<in Any> {
    fun validate(value: Any?): List<ApiError>
}

class NamedValidator(override val name: String) : Validator<Any>, Named {
    override fun validate(value: Any?): List<ApiError> {
        throw IllegalStateException("wrong method use")
    }
}

object EmailValidator : Validator<String> {
    override fun validate(value: String?): List<ApiError> {
        return when {
            value!!.contains('@') -> errors()
            else -> errors("wrong email")
        }
    }
}

object NotEmptyValidator : Validator<String> {
    override fun validate(value: String?): List<ApiError> {
        return when {
            value == null -> errors("can be not null")
            value.isBlank() -> errors("can be not empty")
            else -> errors("wrong email")
        }
    }
}

class StringLengthValidator(private val minInclude: Int, private val maxInclude: Int) : Validator<String> {
    override fun validate(value: String?): List<ApiError> {
        val length = value!!.length
        return when {
            length < minInclude -> errors("can be more $minInclude")
            length > maxInclude -> errors("can be less $maxInclude")
            else -> errors()
        }
    }
}