package com.app.mvvmdemo.apicall

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*


interface APICallInterface {

    @POST
    fun callAPIs(
        @Header("Authorization") auth: String,
        @Header("app-version") app_version: String,
        @Body data: JsonObject,
        @Url url: String
    ): Call<JsonElement>

    @GET
    fun callAPIs(
        @Header("Authorization") auth: String?,
        @Header("app-version") app_version: String?,
        @Url url: String
    ): Call<JsonElement>

}