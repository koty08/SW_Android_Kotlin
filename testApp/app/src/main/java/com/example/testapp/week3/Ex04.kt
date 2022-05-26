package com.example.testapp.week3

fun change(str: String):String{
    var errStr = "";
    var retStr = "";
    for (i:Int in 0..str.length-1)
        if(str[i].toInt() < 97 || str[i].toInt() > 122)
            errStr += str[i]
        else
            retStr += (str[i].toInt()-32).toChar()

    if(errStr != "")
        return "error With = $errStr"
    else
        return retStr
}

fun main(){
    var a = "abcd"
    println(change(a))

    var b = "EfgH"
    println(change(b))

    var c = "!@%$"
    println(change(c))
}