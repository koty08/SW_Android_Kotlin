package com.example.testapp.week6

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.testapp.R

class Ex04_Temp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex04_temp)

        val textName = findViewById<TextView>(R.id.textName1)
        val textAge = findViewById<TextView>(R.id.textAge1)
        val textPhone = findViewById<TextView>(R.id.textPhone1)
        val textAddr = findViewById<TextView>(R.id.textAddr1)
        val textOther = findViewById<TextView>(R.id.textOther1)
        val photo = findViewById<ImageView>(R.id.img1)
        var image = intent.getParcelableExtra<Bitmap>("image")

        textName.text = intent.getStringExtra("name")
        textAge.text = intent.getStringExtra("age")
        textPhone.text = intent.getStringExtra("phone")
        textAddr.text = intent.getStringExtra("addr")
        textOther.text = intent.getStringExtra("other")
        photo.setImageBitmap(image)

        val btnMod = findViewById<Button>(R.id.btn_mod)
        val btnComp = findViewById<Button>(R.id.btn_comp1)

        btnMod.setOnClickListener{
            var intent = Intent(this, Ex04::class.java)
            intent.putExtra("name", textName.text.toString())
            intent.putExtra("age", textAge.text.toString())
            intent.putExtra("phone", textPhone.text.toString())
            intent.putExtra("addr", textAddr.text.toString())
            intent.putExtra("other", textOther.text.toString())
            intent.putExtra("image", image)
            setResult(RESULT_OK, intent)
            finish()
        }

        btnComp.setOnClickListener {
            var intent = Intent(this, Ex04_Comp::class.java)
            intent.putExtra("name", textName.text.toString())
            intent.putExtra("age", textAge.text.toString())
            intent.putExtra("phone", textPhone.text.toString())
            intent.putExtra("addr", textAddr.text.toString())
            intent.putExtra("other", textOther.text.toString())
            intent.putExtra("image", image)
            startActivity(intent)
            finish()
        }
    }
}