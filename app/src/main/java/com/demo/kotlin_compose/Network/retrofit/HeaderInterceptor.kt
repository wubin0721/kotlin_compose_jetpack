package com.demo.kotlin_compose.Network.retrofit

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : BaseInterceptor() {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val newRequest: Request
        newRequest = try {
            request.newBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
            return chain.proceed(request)
        }
        return chain.proceed(newRequest)
    }
}
