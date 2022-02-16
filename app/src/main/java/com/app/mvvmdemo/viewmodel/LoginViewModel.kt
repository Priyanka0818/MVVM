package com.app.mvvmdemo.viewmodel

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.app.mvvmdemo.model.ErrorModel
import com.app.mvvmdemo.model.LoginManualModel
import com.app.mvvmdemo.repository.UserRepository
import com.app.mvvmdemo.utils.AppConstants
import com.app.mvvmdemo.view.ListActivity
import com.app.mvvmdemo.view.LoginActivity
import com.google.gson.Gson
import com.google.gson.JsonObject


class LoginViewModel(var context: LoginActivity) : BaseObservable() {

    var email: String? = ""
    var password: String? = ""
    var errorEmail = ObservableField<String>()
    private var userMutableLiveData: MutableLiveData<LoginManualModel>? = null

    fun onLoginClicked() {
        Log.e("LoginViewModel", "email: ${email} password: ${password}")
        val jsonObject = JsonObject()
        try {
            jsonObject.addProperty("email", email)
            jsonObject.addProperty("password", password)
            jsonObject.addProperty(
                "device_token",
                "gdfgdfgdfgdfgdfg"
            )
            jsonObject.addProperty("platform", "android")
            jsonObject.addProperty("lat", "")
            jsonObject.addProperty("lng", "")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        UserRepository.callAPI(
            jsonObject,
            AppConstants.APIMarks.API_LOGIN,
            AppConstants.HTTPMethod.HTTP_POST
        )
            .observe(context) { loginModel ->
                if (loginModel.isSuccessful) {
                    errorEmail.set("success")
                    val loginManualModel =
                        Gson().fromJson(loginModel.body(), LoginManualModel::class.java)
                    userMutableLiveData?.value = loginManualModel
                    Toast.makeText(context, loginManualModel.status, Toast.LENGTH_LONG).show()
                    context.startActivity(Intent(context, ListActivity::class.java))
                } else {
                    errorEmail.set("failure")
                    val errorModel =
                        Gson().fromJson(loginModel.errorBody()?.string(), ErrorModel::class.java)
                    Toast.makeText(context, errorModel.error_data!![0], Toast.LENGTH_LONG).show()
                }
            }
    }
}