package com.github.sergio5990.remember.dsl.core.gateway

interface Named {
  val name: String
}

enum class ValidatorName : Named {
  ROLE_VALIDATOR,
}

enum class PageName : Named {
  LOGIN_PAGE
}

enum class WidgetName : Named {
  LOGIN_WIDGET
}

enum class ActionName : Named {
  INIT_LOGIN_PLACEHOLDER,
  REDIRECT,
  AUTH
}

enum class FieldName(val fieldName: String) : Named {
  LOGIN("login"),
  PASSWORD("password")
}



