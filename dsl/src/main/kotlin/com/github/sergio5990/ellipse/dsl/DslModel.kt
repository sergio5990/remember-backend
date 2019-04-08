package com.github.sergio5990.ellipse.dsl

class GatewayDescription {
  val pages = mutableListOf<PageDescription>()
  val widgets = mutableListOf<WidgetDescription>()
}

class PageDescription(val name: Named) {
  val validators = mutableListOf<Validator<*>>()
  val widgets = mutableListOf<Named>()
}

class WidgetDescription(val name: Named) {
  var readAction: WidgetReadDescription = WidgetReadDescription()
  var writeAction: WidgetWriteDescription = WidgetWriteDescription()
}

class WidgetReadDescription {
  val validators = mutableListOf<Validator<*>>()
  val outcomingFields = mutableListOf<String>()
  val initActions = mutableListOf<Named>()
}

class WidgetWriteDescription {
  val incomingFields = mutableListOf<IncomingFieldDescription>()
  val outcomingFields = mutableListOf<String>()
  val namedValidators = mutableListOf<Named>()
  val validators = mutableListOf<Validator<*>>()
  val routes = mutableListOf<Named>()
}

class IncomingFieldDescription(val name: Named,
                               val type: Class<*>,
                               val validators: List<Validator<*>>)
