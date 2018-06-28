package com.hafiznaufalr.net.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hafiznaufalr.net.footballclub.model.Footballdc
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getSerializableExtra("data") as Footballdc
        Glide.with(this)
                .load(data.image)
                .into(image_view)
        text_view.text = data.name
        text_view_detail.text = data.detail
    }
}
