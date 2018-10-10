package com.andrehofmeister.schoolhouse.redirect

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest

@WebFilter("/*")
class RedirectFilter : Filter {
  private val skipServletPath: List<String> by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    listOf("/rest", "/css", "/img", "/js", "/Arquillian") // This should be combined in assets
  }

  private val indexHtmlResource: ByteArray by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    this.javaClass.classLoader.getResourceAsStream("../../index.html").use {
      it?.readBytes() ?: ByteArray(0)
    }
  }

  /**
   * Serves `index.html` if the URL doesn't match any static assets. Required for Vue.js HTML5 History Mode.
   */
  override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    if (request is HttpServletRequest) {
      if (skipServletPath.any { request.servletPath.startsWith(it) }) {
        request.getRequestDispatcher("${request.servletPath}${(request.pathInfo?.toString() ?: "")}").forward(request, response)
      } else {
        indexHtmlResource.inputStream().copyTo(response.outputStream)
      }
    }
  }
}
