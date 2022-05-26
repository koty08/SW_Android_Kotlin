package com.example.testapp.week6

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex02_Sub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex02_sub)

        val btn : Button = findViewById(R.id.btn_sub_ex02)
        val ev = findViewById<EditText>(R.id.ev_sub)
        val res = findViewById<TextView>(R.id.res_sub)

        res.text = intent.getStringExtra("data")

        btn.setOnClickListener{
            if (ev.text.isEmpty()){
                Toast.makeText(this, "값을 입력 해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data:String = ev.text.toString()
            val intent = Intent(this, Ex02::class.java)
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            ev.text = null
            finish()
        }
    }
}