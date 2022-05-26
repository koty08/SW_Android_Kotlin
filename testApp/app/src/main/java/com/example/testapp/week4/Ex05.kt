package com.example.testapp.week4

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex05 : AppCompatActivity() {
    lateinit var linLay : LinearLayout; lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week4_ex05)

        linLay = findViewById(R.id.LinLay)
        btn = findViewById(R.id.Button)

        var count = 0
        btn.setOnClickListener{
            if(count == 0){
                linLay.setBackgroundColor(Color.parseColor("#FF0000"))
                count = 1
            } else if(count == 1){
                linLay.setBackgroundColor(Color.parseColor("#00FF00"))
                count = 2
            } else {
                linLay.setBackgroundColor(Color.parseColor("#0000FF"))
                count = 0
            }
        }
    }
}