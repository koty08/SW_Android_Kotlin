package com.example.testapp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()

    var T = IntArray(N + 10)
    var P = IntArray(N + 10)
    var dp = IntArray(N + 10)

    var max = 0
    for (i in 1..N){
        val token = StringTokenizer(readLine());
        T[i] = token.nextToken().toInt()
        P[i] = token.nextToken().toInt()
        dp[i] = P[i];
    }

    for(i in N downTo 0){
        if(i + T[i] > N + 1) {
            dp[i] = dp[i+1]
        } else {
            dp[i] = max(dp[i+1], dp[i+T[i]] + P[i])
        }
    }
    max = dp[1]
    println(max)
}