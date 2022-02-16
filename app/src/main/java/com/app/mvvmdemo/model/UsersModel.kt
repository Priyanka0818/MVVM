package com.app.mvvmdemo.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UsersModel {
    var page = 0
    var per_page = 0
    var total = 0
    var total_pages = 0
    var data: ArrayList<Data>? = null
    var support: Support? = null


    class Data {
        var id: Int? = null
        val email: String? = null
        val first_name: String? = null
        val last_name: String? = null
        val avatar: String? = null


        // important code for loading image here
        companion object {
            @JvmStatic
            @BindingAdapter("avatar")
            fun loadImage(imageView: ImageView, imageURL: String?) {
                Glide.with(imageView.context)
                    .setDefaultRequestOptions(
                        RequestOptions()
                            .circleCrop()
                    )
                    .load(imageURL)
                    .into(imageView)
            }
        }
    }

    class Support {
        var url: String? = null
        var text: String? = null
    }
}
