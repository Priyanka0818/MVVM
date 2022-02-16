package com.app.mvvmdemo.apicall

class APICallHandler {

    companion object {
        val apiCallInterface: APICallInterface? =
            com.app.mvvmdemo.apiclient.APIClient.getClient()?.create(APICallInterface::class.java)
    }


}