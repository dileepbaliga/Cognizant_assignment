package com.example.jsonparsingapplication.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide



@BindingAdapter("avatar")
fun ImageView.bindAuthorPic(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl).apply(RequestOptions().circleCrop())
        .into(this)
}