package com.github.sergio5990.remember.dsl.core.gateway

interface UserService {
  fun loadUser(userId: Long): User
}

class MockUserService: UserService{
  override fun loadUser(userId: Long): User {
    return User("Sergey", 1L, setOf(RoleName.GUEST))
  }
}