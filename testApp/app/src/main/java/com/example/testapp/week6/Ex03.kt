package com.example.testapp.week6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex03)

        val editName = findViewById<EditText>(R.id.editName)
        val editAge = findViewById<EditText>(R.id.editAge)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editAddr = findViewById<EditText>(R.id.editAddr)
        val editOther = findViewById<EditText>(R.id.editOther)

        val btn : Button = findViewById(R.id.btn_save)

        btn.setOnClickListener{
            val intent = Intent(this, Ex03_Sub::class.java)
            intent.putExtra("name", editName.text.toString())
            intent.putExtra("age", editAge.text.toString())
            intent.putExtra("phone", editPhone.text.toString())
            intent.putExtra("addr", editAddr.text.toString())
            intent.putExtra("other", editOther.text.toString())
            startActivityForResult(intent, 100)
            editName.text = null
            editAge.text = null
            editPhone.text = null
            editAddr.text = null
            editOther.text = null
        }
    }
}