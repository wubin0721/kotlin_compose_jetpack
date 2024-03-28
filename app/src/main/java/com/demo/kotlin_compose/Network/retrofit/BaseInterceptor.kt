package com.demo.kotlin_compose.Network.retrofit

import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.Interceptor


abstract class BaseInterceptor : Interceptor {
    protected fun getUrlParams(chain: Interceptor.Chain): LinkedHashMap<String, String?> {
        val url: HttpUrl = chain.request().url
        val size = url.querySize
        val params = LinkedHashMap<String, String?>()
        for (i in 0 until size) {
            params[url.queryParameterName(i)] = url.queryParameterValue(i)
        }
        return params
    }

    protected fun getBodyParameters(chain: Interceptor.Chain): LinkedHashMap<String, String> {
        val formBody = chain.request().body as FormBody
        val params = LinkedHashMap<String, String>()
        val size = formBody.size
        for (i in 0 until size) {
            params[formBody.name(i)] = formBody.value(i)
        }
        return params
    }
}
