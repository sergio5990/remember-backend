package com.github.sergio5990.ellipse.dsl

fun gateway(context: GatewayContext, code: GatewayDescription.() -> Unit) = GatewayDescription().apply(code)

fun GatewayDescription.page(name: Named, init: PageDescription.() -> Unit) {
  pages += PageDescription(name).apply(init)
}

fun GatewayDescription.widget(name: Named, init: WidgetDescription.() -> Unit) {
  widgets += WidgetDescription(name).apply(init)
}

fun WidgetDescription.read(init: WidgetReadDescription.() -> Unit) {
  readAction = WidgetReadDescription().apply(init)
}

fun WidgetDescription.write(init: WidgetWriteDescription.() -> Unit) {
  writeAction = WidgetWriteDescription().apply(init)
}

fun field(fieldName: Named, type: Class<*>, validators: List<Validator<*>>): IncomingFieldDescription {
  return IncomingFieldDescription(fieldName, type, validators)
}

// ----------extend

fun hasRole(role: RoleName): Validator<GatewayContext> {
  return RoleValidator(listOf(role))
}

fun length(minInclude: Int, maxInclude: Int): Validator<String> {
  return StringLengthValidator(minInclude, maxInclude)
}

fun type(type: Any): Class<*> {
  return type.javaClass
}

fun email(): Validator<String> {
  return EmailValidator
}

fun notEmpty(): Validator<String> {
  return NotEmptyValidator
}

