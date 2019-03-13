package com.github.sergio5990.remember.dsl.core.script

import javax.script.Compilable
import javax.script.ScriptEngineManager

object ResourceLoader

val engine = ScriptEngineManager().getEngineByExtension("kts") as Compilable

/*fun runScript(name: String): {
}*/

fun loadScripts() {
  val classLoader = ResourceLoader.javaClass.classLoader
  val script = classLoader.getResource("/widgets.gateway.static.kts").readText()
}

class ScriptRunner{

}