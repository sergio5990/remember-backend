import com.github.sergio5990.remember.dsl.core.gateway.*
import com.github.sergio5990.remember.dsl.core.gateway.ActionName.*
import com.github.sergio5990.remember.dsl.core.gateway.FieldName.*
import com.github.sergio5990.remember.dsl.core.gateway.PageName.*
import com.github.sergio5990.remember.dsl.core.gateway.RoleName.*
import com.github.sergio5990.remember.dsl.core.gateway.ValidatorName.*
import com.github.sergio5990.remember.dsl.core.gateway.WidgetName.*
import com.github.sergio5990.remember.dsl.core.gateway.dsl.*

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
          field(LOGIN, listOf(notEmpty(), length(5, 20), email())),
          field(PASSWORD, listOf(notEmpty(), length(8, 255)))
      )
      outcomingFields += listOf("page")
      routes += listOf(AUTH, REDIRECT)
    }
  }
}



