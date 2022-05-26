package com.example.testapp.week6

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import com.example.testapp.R

class Ex04 : AppCompatActivity() {
    private final var GALLERY = 1
    lateinit var bitmap : Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_ex04)

        val editName = findViewById<EditText>(R.id.editName)
        val editAge = findViewById<EditText>(R.id.editAge)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editAddr = findViewById<EditText>(R.id.editAddr)
        val editOther = findViewById<EditText>(R.id.editOther)
        val photo = findViewById<ImageView>(R.id.img)

        photo.setOnClickListener{
            openGallery()
        }

        val btn : Button = findViewById(R.id.btn_save)

        btn.setOnClickListener{
            val intent = Intent(this, Ex04_Temp::class.java)
            intent.putExtra("name", editName.text.toString())
            intent.putExtra("age", editAge.text.toString())
            intent.putExtra("phone", editPhone.text.toString())
            intent.putExtra("addr", editAddr.text.toString())
            intent.putExtra("other", editOther.text.toString())
            intent.putExtra("image", bitmap)
            startActivityForResult(intent, 100)
            editName.text = null
            editAge.text = null
            editPhone.text = null
            editAddr.text = null
            editOther.text = null
            photo.setImageResource(R.mipmap.ic_launcher_round)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val editName = findViewById<EditText>(R.id.editName)
        val editAge = findViewById<EditText>(R.id.editAge)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editAddr = findViewById<EditText>(R.id.editAddr)
        val editOther = findViewById<EditText>(R.id.editOther)
        val img = findViewById<ImageView>(R.id.img)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == GALLERY){
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.data)
                bitmap = resizeBitmap(bitmap, 300, 300)
                img.setImageBitmap(bitmap)
            }
            else if(requestCode == 100){
                editName.setText(data!!.getStringExtra("name"))
                editAge.setText(data.getStringExtra("age"))
                editPhone.setText(data.getStringExtra("phone"))
                editAddr.setText(data.getStringExtra("addr"))
                editOther.setText(data.getStringExtra("other"))
                img.setImageBitmap(data.getParcelableExtra("image"))
            }
        }
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int):Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }
}