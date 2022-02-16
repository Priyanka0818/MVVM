package com.app.mvvmdemo.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.app.mvvmdemo.repository.UserRepository
import com.app.mvvmdemo.utils.AppConstants
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Response


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var projectListObservable: LiveData<Response<JsonElement>>? = null
    var mccNname = ObservableField<String>()
    var mccValue = ObservableField<String>()

    init {
        projectListObservable = UserRepository.callAPI(
            JsonObject(),
            AppConstants.APIMarks.MCC_LIST,
            AppConstants.HTTPMethod.HTTP_GET
        )
    }

    fun getUserListObservable(): LiveData<Response<JsonElement>>? {
        return projectListObservable
    }
}