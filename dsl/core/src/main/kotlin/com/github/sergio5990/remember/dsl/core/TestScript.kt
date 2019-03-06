package com.github.sergio5990.remember.dsl.core

import javax.script.Compilable
import javax.script.ScriptEngineManager
import javax.script.SimpleBindings

fun main(args: Array<String>) {
  val kotlinEngine = ScriptEngineManager().getEngineByExtension("kts")

  println(kotlinEngine.eval("1 + 2"))
  println(kotlinEngine.eval("1 * 2"))
  println(kotlinEngine.eval("a + b", SimpleBindings(mapOf("a" to 1, "b" to 2))))

  val engine = kotlinEngine as Compilable
}