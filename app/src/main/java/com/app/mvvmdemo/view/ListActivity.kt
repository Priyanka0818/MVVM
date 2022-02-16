package com.app.mvvmdemo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmdemo.R
import com.app.mvvmdemo.adapter.MListAdapter
import com.app.mvvmdemo.databinding.ActivityListBinding
import com.app.mvvmdemo.listeners.ListClickListener
import com.app.mvvmdemo.model.IndustryTypeList
import com.app.mvvmdemo.viewmodel.UserViewModel
import com.google.gson.Gson


class ListActivity : AppCompatActivity(), ListClickListener {

    var rvUsers: RecyclerView? = null
    var userAdapter: MListAdapter? = null
    private var binding: ActivityListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        rvUsers = findViewById(R.id.rvUsers)
        val linearLayoutManager =
            LinearLayoutManager(this@ListActivity, LinearLayoutManager.VERTICAL, false)
        rvUsers?.layoutManager = linearLayoutManager

        val userViewModel: UserViewModel = ViewModelProvider(this).get(
            UserViewModel::class.java
        )
        observeViewModel(userViewModel)
    }

    private fun observeViewModel(viewModel: UserViewModel) {
        // Update the list when the data changes
        viewModel.getUserListObservable()
            ?.observe(
                this
            ) { t ->
                val industryTypeList =
                    Gson().fromJson(t.body(), IndustryTypeList::class.java)
                userAdapter =
                    MListAdapter(industryTypeList.success_data!!, this)
                binding?.userAdapter = userAdapter
            }
    }

    override fun onClick(users: IndustryTypeList.Success_data) {
        startActivity(
            Intent(this, ListDetailActivity::class.java).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
            ).putExtra("name", users.name).putExtra("value", users.value)
        )
    }
}