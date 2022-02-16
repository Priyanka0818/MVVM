package com.app.mvvmdemo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.mvvmdemo.R
import com.app.mvvmdemo.databinding.ActivityLoginBinding
import com.app.mvvmdemo.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val loginViewModel = LoginViewModel(this@LoginActivity)
        binding.loginViewModel = loginViewModel
    }
}