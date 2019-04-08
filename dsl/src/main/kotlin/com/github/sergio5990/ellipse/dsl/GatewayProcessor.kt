/*
package com.github.sergio5990.ellipse.dsl.core.gateway.proseccor

import com.github.sergio5990.ellipse.dsl.core.gateway.*
import com.github.sergio5990.ellipse.dsl.core.gateway.dsl.GatewayDescription
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.application.WriteAction

class GatewayBuilder {
  fun build(gatewayDescription: List<GatewayDescription>): List<Page> {

  }
}

interface GatewayProcessor {
  fun read(page: String): ApiResponse<PageResponse>
  fun read(page: String, widget: String): ApiResponse<WidgetResponse>
  fun write(page: String, widget: String): ApiResponse<WidgetResponse>
}

class MultiGatewayProcessor(private val staticProcessor: StaticGatewayProcessor,
                            private val dynamicProcessor: DynamicGatewayProcessor) : GatewayProcessor {

  private fun resolveByType(pageName: String): GatewayProcessor {
    return when {
      staticProcessor.pages.contains(pageName) -> staticProcessor
      dynamicProcessor.dynamicPageNames.contains(pageName) -> dynamicProcessor
      else -> ErrorGatewayProcessor
    }
  }

  override fun read(page: String): ApiResponse<PageResponse> {
    return resolveByType(page).read(page)
  }

  override fun read(page: String, widget: String): ApiResponse<WidgetResponse> {
    return resolveByType(page).read(page, widget)
  }

  override fun write(page: String, widget: String): ApiResponse<WidgetResponse> {
    return resolveByType(page).read(page, widget)
  }
}

object ErrorGatewayProcessor : GatewayProcessor {

  override fun read(page: String): ApiResponse<PageResponse> {
    return response(errors("page with name=$page not exist"))
  }

  override fun read(page: String, widget: String): ApiResponse<WidgetResponse> {
    return response(errors("page with name=$page not exist"))
  }

  override fun write(page: String, widget: String): ApiResponse<WidgetResponse> {
    return response(errors("page with name=$page not exist"))
  }
}

class StaticGatewayProcessor(private val staticPages: List<Page>) : GatewayProcessor {
  val pages = staticPages.map { it.name }.toSet()

  fun read(page: String) {}
  fun read(page: String, widget: String) {
  }

  fun write(page: String, widget: String) {}
}

class DynamicGatewayProcessor(val dynamicPageNames: Set<String>) : GatewayProcessor {

  fun read(page: String) {}
  fun read(page: String, widget: String) {
  }

  fun write(page: String, widget: String) {}
}

class Page(val name: String, val validators: List<Validator<*>>, val widgets: Map<String, Widget>)
class Widget(val readAction: ReadAction, val writeAction: WriteAction)

class PageResponse
class WidgetResponse*/
