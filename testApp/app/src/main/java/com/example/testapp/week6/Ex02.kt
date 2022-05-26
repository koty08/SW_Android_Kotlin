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

class Ex02: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex02)

        val btn : Button = findViewById(R.id.btn_main_ex02)
        val ev = findViewById<EditText>(R.id.ev_main)
        val res = findViewById<TextView>(R.id.res_main)

        btn.setOnClickListener{
            if (ev.text.isEmpty()){
                Toast.makeText(this, "값을 입력 해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val data:String = ev.text.toString()
            val intent = Intent(this, Ex02_Sub::class.java)
            intent.putExtra("data", data)
            startActivityForResult(intent, 100)
            ev.text = null
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res: TextView = findViewById(R.id.res_main)
        if(resultCode == Activity.RESULT_OK){
            when (requestCode) {
                100 -> {
                    res.text = data!!.getStringExtra("data") + "\n-send from sub"
                }
            }
        }
    }
}