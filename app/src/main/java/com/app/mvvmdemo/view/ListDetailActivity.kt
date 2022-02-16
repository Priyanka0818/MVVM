package com.app.mvvmdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.mvvmdemo.R
import com.app.mvvmdemo.databinding.ActivityListDetailBinding
import com.app.mvvmdemo.viewmodel.UserViewModel

class ListDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityListDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_list_detail)
        val userViewModel = UserViewModel(application)
        binding.userViewModel = userViewModel
        userViewModel.mccNname.set(intent.getStringExtra("name"))
        userViewModel.mccValue.set(intent.getStringExtra("value"))
    }
}