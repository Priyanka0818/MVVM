package com.app.mvvmdemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.mvvmdemo.BuildConfig
import com.app.mvvmdemo.apicall.APICallHandler
import com.app.mvvmdemo.utils.AppConstants
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    companion object {

        var methodType: Call<JsonElement>? = null

        fun callAPI(
            jsonObject: JsonObject,
            apiUrl: String,
            method: String
        ): LiveData<Response<JsonElement>> {
            val data: MutableLiveData<Response<JsonElement>> =
                MutableLiveData<Response<JsonElement>>()

            if (method == AppConstants.HTTPMethod.HTTP_POST) {
                methodType = APICallHandler.apiCallInterface?.callAPIs(
                    auth = "",
                    app_version = BuildConfig.VERSION_NAME,
                    data = jsonObject,
                    url = apiUrl
                )
            } else if (method == AppConstants.HTTPMethod.HTTP_GET) {
                methodType = APICallHandler.apiCallInterface?.callAPIs(
                    auth = "",
                    app_version = BuildConfig.VERSION_NAME,
                    url = apiUrl
                )
            }

            methodType?.enqueue(object : Callback<JsonElement> {

                override fun onResponse(
                    call: Call<JsonElement>,
                    response: Response<JsonElement>
                ) {
                    data.value = response
                }

                override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                    Log.e("TodoRepository", "onFailure")
                }
            })
            return data
        }
    }
}