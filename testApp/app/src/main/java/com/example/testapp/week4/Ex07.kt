package com.example.testapp.week4

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex07 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week4_ex07)

        var btnLeft = findViewById<Button>(R.id.BtnLeft)
        var btnRight = findViewById<Button>(R.id.BtnRight)
        var imgView = findViewById<ImageView>(R.id.ImgView)

        var id = 'a'
        btnLeft.setOnClickListener{
            if(id != 'a'){
                id = (id.code - 1).toChar()
                imgView.setImageResource(resources.getIdentifier(id.toString(), "drawable", packageName))
            }
        }

        btnRight.setOnClickListener{
            if(id != 'z'){
                id = (id.code + 1).toChar()
                imgView.setImageResource(resources.getIdentifier(id.toString(), "drawable", packageName))
            }
        }
    }
}