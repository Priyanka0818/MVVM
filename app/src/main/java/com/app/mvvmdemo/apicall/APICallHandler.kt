package com.app.mvvmdemo.apicall

import com.app.mvvmdemo.apiclient.APIClient

class APICallHandler {

    companion object {
        val apiCallInterface: APICallInterface? =
            APIClient.getClient()?.create(APICallInterface::class.java)
    }


}