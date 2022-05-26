package com.example.testapp.week6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex01)
        val btn: Button = findViewById(R.id.btn_main)

        btn.setOnClickListener{
            val intent = Intent(this, Ex01_Sub::class.java)
            startActivity(intent)
        }
    }
}