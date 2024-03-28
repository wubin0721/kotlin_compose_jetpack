package com.demo.kotlin_compose.Interface

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.QueryMap
import retrofit2.http.Streaming
import retrofit2.http.Url

interface RestService {
    @GET
    operator fun get(@Url url: String?, @QueryMap params: Map<String?, Any?>?): Call<String?>?

    @FormUrlEncoded
    @POST
    fun post(@Url url: String?, @FieldMap params: Map<String?, Any?>?): Call<String?>?

    @POST
    fun postRaw(@Url url: String?, @Body body: RequestBody?): Call<String?>?

    @FormUrlEncoded
    @PUT
    fun put(@Url url: String?, @FieldMap params: Map<String?, Any?>?): Call<String?>?

    @PUT
    fun putRaw(@Url url: String?, @Body body: RequestBody?): Call<String?>?

    @DELETE
    fun delete(@Url url: String?, @QueryMap params: Map<String?, Any?>?): Call<String?>?

    @Streaming
    @GET
    fun download(@Url url: String?, @QueryMap params: Map<String?, Any?>?): Call<ResponseBody?>?

    @Multipart
    @POST
    fun upload(@Url url: String?, @Part file: Part?): Call<String?>?
}
