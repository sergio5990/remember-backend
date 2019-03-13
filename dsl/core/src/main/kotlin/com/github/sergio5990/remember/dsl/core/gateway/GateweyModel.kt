package com.github.sergio5990.remember.dsl.core.gateway

open class GatewayContext(private val userId: String,
                     private val userService: UserService) {

  val user: User by lazy { userService.loadUser(userId.toLong()) }
  val extra = hashMapOf<String, Any>()
}

class User(val name: String,
           val id: Long,
           val roles: Set<RoleName>)

enum class RoleName : Named {
  GUEST;
}



