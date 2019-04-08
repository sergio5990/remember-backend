import com.github.sergio5990.ellipse.dsl.*

fun pages() = listOf(LOGIN_PAGE_1).map { it.name }.toSet()

val context = bindings["context"] as GatewayContext
gateway(context) {

    page(LOGIN_PAGE_1) {
        validators += hasRole(GUEST)
        widgets += LOGIN_WIDGET
    }

    widget(LOGIN_WIDGET) {
        if ("OFF" != context.extra["placeholder"]) {
            read {
                outcomingFields += listOf("loginPlaceholder", "passwordPlaceholder")
                initActions += INIT_LOGIN_PLACEHOLDER
            }
        }
        write {
            incomingFields += listOf(
                    field(LOGIN, type(String), listOf(notEmpty(), length(5, 20), email())),
                    field(PASSWORD, type(String), listOf(notEmpty(), length(8, 255)))
            )
            outcomingFields += listOf("page")
            routes += listOf(AUTH, REDIRECT)
        }
    }
}



