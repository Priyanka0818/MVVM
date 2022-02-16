package com.app.mvvmdemo.listeners

import com.app.mvvmdemo.model.IndustryTypeList

interface ListClickListener {

    fun onClick(users: IndustryTypeList.Success_data)
}