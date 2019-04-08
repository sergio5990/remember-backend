package com.github.sergio5990.ellipse.dsl

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion

interface UserService {
  fun loadUser(userId: Long): BIConversion.User
}

class MockUserService: UserService {
  override fun loadUser(userId: Long): BIConversion.User {
    return BIConversion.User("Sergey", 1L, setOf(RoleName.GUEST))
  }
}