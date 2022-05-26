package com.example.testapp.week4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.R

class Ex04 : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var textResult : TextView
    lateinit var btnRem : Button; lateinit var btnExc : Button
    lateinit var num1 : String; lateinit var num2: String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week4_ex04)
        var cnt = 0;
        title = "계산횟수 : ${cnt}회"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnRem = findViewById(R.id.BtnRem)
        btnExc = findViewById(R.id.BtnExc)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }

        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }

        btnRem.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                result = Integer.parseInt(num1) % Integer.parseInt(num2)
                textResult.text = "계산 결과 : " + result.toString()
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }

        btnExc.setOnClickListener{
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.toIntOrNull() == null || num2.toIntOrNull() == null){
                textResult.text = "숫자 값을 입력해주세요!!"
            } else {
                edit1.setText(num2)
                edit2.setText(num1)
                textResult.text = "계산 결과 : "
                cnt+=1
                title = "계산횟수 : ${cnt}회"
            }
        }
    }
}