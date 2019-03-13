package com.github.sergio5990.remember.dsl.core.script

import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngine
import javax.script.ScriptEngineManager
import javax.script.SimpleBindings

fun main(args: Array<String>) {
  val engine = ScriptEngineManager().getEngineByExtension("kts")
  engine as KotlinJsr223JvmLocalScriptEngine

  println(engine.eval("1 + 2"))

  println(engine.eval("""bindings["a"] as Int + bindings["b"] as Int""",
      SimpleBindings(mapOf("a" to 1, "b" to 2))))

  val res1 = engine.eval("""
fun fn(x: Int) = x + 2
class Ter{
    fun fn1(x: Int) = x + 3
}
Ter()
""")
  println(engine.invokeFunction("fn", 3))
  println(engine.invokeMethod(res1, "fn1", 3))
  println(res1.javaClass)

  engine.state.history.reset()
  val compiled = engine.compile("""bindings["c"] as Int + 2""")
  println(compiled.eval(SimpleBindings().apply { put("c", 1) }))
  println(compiled.eval(SimpleBindings().apply { put("c", 2) }))
  println(compiled.eval(SimpleBindings().apply { put("c", 3) }))

}
