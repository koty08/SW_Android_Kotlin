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
import com.example.testapp.R

class Week6Hw : AppCompatActivity() {
    private final var GALLERY = 1
    lateinit var bitmap : Bitmap
    var chk = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week6_hw)

        var editName = findViewById<EditText>(R.id.editName)
        var editEng = findViewById<EditText>(R.id.editEng)
        var editPhone = findViewById<EditText>(R.id.editPhone)
        var editEmail = findViewById<EditText>(R.id.editEmail)
        var editAddr = findViewById<EditText>(R.id.editAddr)
        var img = findViewById<ImageView>(R.id.img)
        var table_1_1 = findViewById<EditText>(R.id.table1_1_1)
        var table_1_2 = findViewById<EditText>(R.id.table1_1_2)
        var table_1_3 = findViewById<EditText>(R.id.table1_1_3)
        var table_1_4 = findViewById<EditText>(R.id.table1_1_4)

        img.setOnClickListener {
            openGallery()
        }

        val btn = findViewById<Button>(R.id.btnHw)

        btn.setOnClickListener{
            val intent = Intent(this, Week6Hw_Sub::class.java)
            intent.putExtra("name", editName.text.toString())
            intent.putExtra("eng", editEng.text.toString())
            intent.putExtra("phone", editPhone.text.toString())
            intent.putExtra("email", editEmail.text.toString())
            intent.putExtra("addr", editAddr.text.toString())
            if (chk == 1){
                intent.putExtra("image", bitmap)
            }
            var arr = ArrayList<String>();
            arr.add(table_1_1.text.toString())
            arr.add(table_1_2.text.toString())
            arr.add(table_1_3.text.toString())
            arr.add(table_1_4.text.toString())
            intent.putExtra("arr", arr)
            startActivityForResult(intent, 100)
            img.setImageResource(R.mipmap.ic_launcher_round)
            editName.text = null
            editEng.text = null
            editPhone.text = null
            editEmail.text = null
            editAddr.text = null
            table_1_1.text = null
            table_1_2.text = null
            table_1_3.text = null
            table_1_4.text = null
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, GALLERY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var editName = findViewById<EditText>(R.id.editName)
        var editEng = findViewById<EditText>(R.id.editEng)
        var editPhone = findViewById<EditText>(R.id.editPhone)
        var editEmail = findViewById<EditText>(R.id.editEmail)
        var editAddr = findViewById<EditText>(R.id.editAddr)
        val img = findViewById<ImageView>(R.id.img)
        var table_1_1 = findViewById<EditText>(R.id.table1_1_1)
        var table_1_2 = findViewById<EditText>(R.id.table1_1_2)
        var table_1_3 = findViewById<EditText>(R.id.table1_1_3)
        var table_1_4 = findViewById<EditText>(R.id.table1_1_4)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == GALLERY){
                chk = 1
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.data)
                bitmap = resizeBitmap(bitmap, 300, 300)
                img.setImageBitmap(bitmap)
            }
            else if(requestCode == 100){
                editName.setText(data!!.getStringExtra("name"))
                editEng.setText(data.getStringExtra("eng"))
                editPhone.setText(data.getStringExtra("phone"))
                editAddr.setText(data.getStringExtra("addr"))
                editEmail.setText(data.getStringExtra("email"))
                img.setImageBitmap(data.getParcelableExtra("image"))
                var arr = data.getStringArrayListExtra("arr")
                if (arr != null) {
                    table_1_1.setText(arr.get(0))
                    table_1_2.setText(arr.get(1))
                    table_1_3.setText(arr.get(2))
                    table_1_4.setText(arr.get(3))
                }
            }
        }
    }

    private fun resizeBitmap(bitmap: Bitmap, width: Int, height: Int):Bitmap {
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }
}