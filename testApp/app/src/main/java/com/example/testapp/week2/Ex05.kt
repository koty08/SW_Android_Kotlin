package com.example.testapp

import java.util.*

fun main() {
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()

    val sc : Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for(i : Int in 0..num - 1 step(1)){
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for(i : Int in 0..num-1 step(1)){
        var n = pairList.get(i);
        var flag = false;
        print("Pairs for $n : ")
        for(j in 1..n-1){
            for(k in 1..n-1) {
                if(j + k == n && j < k){
                    if(!flag){
                        print("($j $k)")
                        flag = true;
                    } else {
                        print(", ($j $k)")
                    }
                }
            }
        }
        println()
    }
}