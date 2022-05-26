package com.example.testapp.week6

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex04_Comp: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex04_comp)

        val textName = findViewById<TextView>(R.id.textName2)
        val textAge = findViewById<TextView>(R.id.textAge2)
        val textPhone = findViewById<TextView>(R.id.textPhone2)
        val textAddr = findViewById<TextView>(R.id.textAddr2)
        val textOther = findViewById<TextView>(R.id.textOther2)
        val photo = findViewById<ImageView>(R.id.img2)
        var image = intent.getParcelableExtra<Bitmap>("image")

        textName.text = intent.getStringExtra("name")
        textAge.text = intent.getStringExtra("age")
        textPhone.text = intent.getStringExtra("phone")
        textAddr.text = intent.getStringExtra("addr")
        textOther.text = intent.getStringExtra("other")
        photo.setImageBitmap(image)

    }
}