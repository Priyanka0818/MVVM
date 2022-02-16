package com.app.mvvmdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class IndustryTypeList {
    @Expose
    @SerializedName("success_data")
    var success_data: ArrayList<Success_data>? = null

    @Expose
    @SerializedName("status")
    var status: String? = null

    class Success_data {
        @Expose
        @SerializedName("name")
        var name: String? = null

        @Expose
        @SerializedName("value")
        var value: String? = null

        @Expose
        @SerializedName("code")
        var code: String? = null
        var isChecked = false
    }
}