package com.example.week9ex04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week9ex04.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    lateinit var job : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var channel = Channel<Int>()
        val backgroundScope = CoroutineScope(Dispatchers.Default)
        var last = 0

        binding.button1.setOnClickListener {
            job = backgroundScope.launch {
                var time = measureTimeMillis{
                    for (i in 0..100){
                        channel.send(i)
                        delay(1000)
                    }
                }
            }
        }

        binding.button2.setOnClickListener {
            job.cancel()
            binding.timeView.text = "00:00:00"
        }

        binding.button3.setOnClickListener {
            job.cancel()
        }

        binding.button4.setOnClickListener {
            job = backgroundScope.launch {
                var time = measureTimeMillis {
                    for (i in last..100){
                        channel.send(i)
                        delay(1000)
                    }
                }
            }
        }

        var hour : Int
        var min : Int
        var sec : Int
        var mainScope = GlobalScope.launch(Dispatchers.Main) {
            channel.consumeEach {
                last = it
                hour = last / 3600
                min = (it - hour * 3600) / 60
                sec = (it - hour * 3600 - min * 60)

                val s_hour = if(hour > 9) hour.toString() else "0$hour"
                val s_min = if(min > 9) min.toString() else "0$min"
                val s_sec = if(sec > 9) sec.toString() else "0$sec"

                binding.timeView.text = s_hour+ ":" + s_min + ":" + s_sec
            }
        }
    }
}