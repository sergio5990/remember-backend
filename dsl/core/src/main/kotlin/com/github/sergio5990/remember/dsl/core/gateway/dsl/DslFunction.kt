package com.github.sergio5990.remember.dsl.core.gateway.dsl

import com.github.sergio5990.remember.dsl.core.gateway.*

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

fun field(fieldName: Named, validators: List<Validator<*>>): IncomingFieldDescription {
  return IncomingFieldDescription(fieldName, validators)
}

// ----------extend

fun hasRole(role: RoleName): Validator<GatewayContext> {
  return RoleValidator(listOf(role))
}

fun length(minInclude: Int, maxInclude: Int): Validator<String> {
  return StringLengthValidator(minInclude, maxInclude)
}

fun email(): Validator<String> {
  return EmailValidator
}

fun notEmpty(): Validator<String> {
  return NotEmptyValidator
}

