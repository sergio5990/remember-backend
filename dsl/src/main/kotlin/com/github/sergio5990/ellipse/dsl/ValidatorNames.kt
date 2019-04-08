package com.github.sergio5990.ellipse.dsl

import com.apple.laf.AquaButtonBorder

enum class ValidatorName : AquaButtonBorder.Named {
    ROLE_VALIDATOR,
}

enum class PageName : AquaButtonBorder.Named {
    LOGIN_PAGE,
    LOGIN_PAGE_1
}

enum class WidgetName : AquaButtonBorder.Named {
    LOGIN_WIDGET
}

enum class ActionName : AquaButtonBorder.Named {
    INIT_LOGIN_PLACEHOLDER,
    REDIRECT,
    AUTH
}

enum class FieldName(val fieldName: String) : AquaButtonBorder.Named {
    LOGIN("login"),
    PASSWORD("password")
}

class LoginRequest(val login:String, val password: String)