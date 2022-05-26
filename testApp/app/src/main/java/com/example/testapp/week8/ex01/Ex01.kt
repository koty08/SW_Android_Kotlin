package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Ex01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week7_ex01_main)

        val fragButton = findViewById<Button>(R.id.fragBtn1)
        val fragmentManager: FragmentManager = supportFragmentManager
        var onClicked = false
        fragButton.setOnClickListener{
            if(onClicked){
                onClicked=false
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                val frameLayout = supportFragmentManager.findFragmentById(R.id.fragment_content)
                transaction.remove(frameLayout!!).commit()
            } else {
                onClicked=true
                val transaction: FragmentTransaction = fragmentManager.beginTransaction()
                transaction.add(R.id.fragment_content, OneFragment()).commit()
            }
        }
    }
}

class OneFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bind, container, false)
    }
}