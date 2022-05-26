package com.example.ex05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.ex05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewpager.adapter = MyPagerAdapter(this)
        binding.viewpager.orientation =ViewPager2.ORIENTATION_HORIZONTAL

        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){ return true }
        return super.onOptionsItemSelected(item)
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