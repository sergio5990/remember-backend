import com.github.sergio5990.ellipse.dsl.*

val context = bindings["context"] as GatewayContext
gateway(context) {

  page(LOGIN_PAGE) {
    validators += hasRole(GUEST)
    widgets += LOGIN_WIDGET
  }

  widget(LOGIN_WIDGET) {
    read {
      outcomingFields += listOf("loginPlaceholder", "passwordPlaceholder")
      initActions += INIT_LOGIN_PLACEHOLDER
    }
    write {
      incomingFields += listOf(
              field(LOGIN, type(String), listOf(notEmpty(), length(5, 20), email())),
              field(PASSWORD, type(String), listOf(notEmpty(), length(8, 255)))
      )
      outcomingFields += listOf("page") //return typed
      routes += listOf(AUTH, REDIRECT) //new dsl entity
    }
  }
}



