package com.divinegrace.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fashion_detail.*


class FashionDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fashion_detail)
        val bundle=intent.extras

      /*V  ivFashionImage.setImageResource(bundle.getInt("image"))
       //tvName.text=bundle.getString("name")
        tvName.text=bundle.getString("name")
        tvDetails.text=bundle.getString("des")*/

        ivFashionImage.setImageResource(bundle.getInt("image"))
        tvName.text=bundle.getString("name")
        tvName.text=bundle.getString("des")

    }
}
