package com.github.sergio5990.remember.gateway.page

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import javax.script.Compilable
import javax.script.ScriptEngineManager
import javax.script.SimpleBindings

@SpringBootConfiguration
@EnableAutoConfiguration
class GatewayApp


data class Spec(val pages: MutableList<PageSpec> = mutableListOf<PageSpec>(),
                val widgets: MutableList<WidgetSpec> = mutableListOf<WidgetSpec>())


data class PageSpec(val name: String,
                    var predicates: List<String> = listOf<String>(),
                    var widgets: List<String> = listOf<String>())

data class WidgetSpec(val name: String,
                      var showPredicates: List<String> = mutableListOf<String>(),
                      var read: WidgetReadSpec = WidgetReadSpec(),
                      var write: WidgetWriteSpec = WidgetWriteSpec())

data class WidgetReadSpec(var readOnly: List<String> = listOf<String>(),
                          var initActions: List<String> = listOf<String>())

data class WidgetWriteSpec(var fields: List<String> = listOf<String>(),
                           var jsonValidators: List<String> = listOf<String>(),
                           var validators: List<String> = listOf<String>(),
                           var completeActions: List<String> = listOf<String>())

data class SpecContext(val x: Int,
                       val y: Int,
                       val extra: Map<String, Any>)


data class Page(val name: String,
                val predicates: List<(Any) -> Boolean>,
                val widgets: List<Widget>)

data class Widget(val name: String)


fun main(args: Array<String>) {
    val engine = ScriptEngineManager().getEngineByExtension("kts") as Compilable
    val readText = GatewayApp::class.java.getResource("/widgets.kts").readText()
    val eval = engine.compile(readText)

    val apply = SimpleBindings().apply {
        put("context", SpecContext(1, 2, hashMapOf("3" to "4")))
    }
    val spec1 = eval.eval(apply).takeIf { it is Spec } as Spec
    println(spec1)

    val apply2 = SimpleBindings().apply {
        put("context", SpecContext(0, 5, hashMapOf("42" to "24")))
    }
    val spec2 = eval.eval(apply2).takeIf { it is Spec } as Spec
    println(spec2)
}

