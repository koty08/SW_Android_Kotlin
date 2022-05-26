package com.example.testapp.week4

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week4_ex06)

        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var btn4 = findViewById<Button>(R.id.btn4)
        var btn5 = findViewById<Button>(R.id.btn5)

        btn1.setOnClickListener{
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
        }

        btn2.setOnClickListener{
            btn2.visibility = View.INVISIBLE
            btn3.visibility = View.VISIBLE
        }

        btn3.setOnClickListener{
            btn3.visibility = View.INVISIBLE
            btn4.visibility = View.VISIBLE
        }

        btn4.setOnClickListener{
            btn4.visibility = View.INVISIBLE
            btn5.visibility = View.VISIBLE
        }

        btn5.setOnClickListener{
            btn5.visibility = View.INVISIBLE
            btn1.visibility = View.VISIBLE
        }
    }
}