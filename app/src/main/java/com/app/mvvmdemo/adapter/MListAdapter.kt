package com.app.mvvmdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmdemo.BR
import com.app.mvvmdemo.R
import com.app.mvvmdemo.listeners.ListClickListener
import com.app.mvvmdemo.model.IndustryTypeList


class MListAdapter(var userList: ArrayList<IndustryTypeList.Success_data>, var listener: ListClickListener) :
    RecyclerView.Adapter<MListAdapter.UserViewHolder>() {


    class UserViewHolder(var viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(itemViewModel: IndustryTypeList.Success_data,listener: ListClickListener) {
            viewDataBinding.setVariable(BR.userModel, itemViewModel)
            viewDataBinding.setVariable(BR.userClickListener, listener)
            viewDataBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_layout,
            parent,
            false
        )

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position],listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}