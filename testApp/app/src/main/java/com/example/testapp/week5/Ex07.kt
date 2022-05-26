package com.example.testapp.week5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex07 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week5_ex07)

        var btn0 = findViewById<Button>(R.id.btn0)
        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var btn4 = findViewById<Button>(R.id.btn4)
        var btn5 = findViewById<Button>(R.id.btn5)
        var btn6 = findViewById<Button>(R.id.btn6)
        var btn7 = findViewById<Button>(R.id.btn7)
        var btn8 = findViewById<Button>(R.id.btn8)
        var btn9 = findViewById<Button>(R.id.btn9)
        var btnStar = findViewById<Button>(R.id.btnStar)
        var btnSharp = findViewById<Button>(R.id.btnSharp)
        var btnBack = findViewById<ImageButton>(R.id.btnBack)

        var editT = findViewById<EditText>(R.id.editT)

        btn0.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("0")
            editT.setText(str)
        }

        btn1.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("1")
            editT.setText(str)
        }

        btn2.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("2")
            editT.setText(str)
        }

        btn3.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("3")
            editT.setText(str)
        }

        btn4.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("4")
            editT.setText(str)
        }

        btn5.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("5")
            editT.setText(str)
        }

        btn6.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("6")
            editT.setText(str)
        }

        btn7.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("7")
            editT.setText(str)
        }

        btn8.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("8")
            editT.setText(str)
        }

        btn9.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("9")
            editT.setText(str)
        }

        btnStar.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("*")
            editT.setText(str)
        }

        btnSharp.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 3 || editT.text.length == 8){
                str.append("-")
            }
            str.append("#")
            editT.setText(str)
        }

        btnBack.setOnClickListener{
            var str = editT.text
            if(editT.text.length == 5 || editT.text.length == 10){
                str.delete(str.length-2, str.length)
            } else {
                str.delete(str.length-1, str.length)
            }
            editT.setText(str)
        }
    }
}