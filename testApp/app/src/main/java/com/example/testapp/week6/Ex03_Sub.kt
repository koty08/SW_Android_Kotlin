package com.example.testapp.week6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex03_Sub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex03_sub)

        val textNameAge = findViewById<TextView>(R.id.textNameAge)
        val textPhone = findViewById<TextView>(R.id.textPhone)
        val textAddr = findViewById<TextView>(R.id.textAddr)
        val textOther = findViewById<TextView>(R.id.textOther)

        textNameAge.text = intent.getStringExtra("name") + "  " + intent.getStringExtra("age")
        textPhone.text = intent.getStringExtra("phone")
        textAddr.text = intent.getStringExtra("addr")
        textOther.text = intent.getStringExtra("other")

        val btn : Button = findViewById(R.id.btn_comp)

        btn.setOnClickListener{
            finish()
        }
    }
}