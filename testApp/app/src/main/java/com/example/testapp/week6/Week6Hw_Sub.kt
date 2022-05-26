package com.example.testapp.week6

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Week6Hw_Sub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_hw_sub)

        val textName = findViewById<TextView>(R.id.textName)
        val textEng = findViewById<TextView>(R.id.textEng)
        val textPhone = findViewById<TextView>(R.id.textPhone)
        val textEmail = findViewById<TextView>(R.id.textEmail)
        val textAddr = findViewById<TextView>(R.id.textAddr)
        val photo = findViewById<ImageView>(R.id.img_sub)
        var image = intent.getParcelableExtra<Bitmap>("image")

        textName.text = intent.getStringExtra("name")
        textEng.text = intent.getStringExtra("eng")
        textPhone.text = intent.getStringExtra("phone")
        textAddr.text = intent.getStringExtra("addr")
        textEmail.text = intent.getStringExtra("email")
        if(image != null){
            photo.setImageBitmap(image)
        }
        var arr = intent.getStringArrayListExtra("arr")

        val btn = findViewById<Button>(R.id.btnHwSub)
        btn.setOnClickListener{
            val intent = Intent(this, Week6Hw::class.java)
            intent.putExtra("name", textName.text.toString())
            intent.putExtra("eng", textEng.text.toString())
            intent.putExtra("phone", textPhone.text.toString())
            intent.putExtra("email", textEmail.text.toString())
            intent.putExtra("addr", textAddr.text.toString())
            intent.putExtra("image", image)
            intent.putExtra("arr", arr)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}