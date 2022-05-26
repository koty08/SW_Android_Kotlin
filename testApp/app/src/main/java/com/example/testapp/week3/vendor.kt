package com.example.testapp.week3

import java.util.*


class Vendor(){
    val sc : Scanner = Scanner(System.`in`)
    fun getChange(money: Int, price: Int){
        println("감사합니다. 잔돈반환:${money-price}")
    }

    fun getCoin(menu : String): String? {
        println("Insert Coin")
        var line = sc.nextLine()
        var money = line.toIntOrNull()

        if(money == null){
            println("돈을 넣지 않았습니다.")
            println("다시 돈을 넣어주세요.")
            return null
        }

        println("$money 원을 넣었습니다.")

        var price = getPrice(menu.toInt())
        if(price > money){
            println("현금이 부족합니다.")
        } else {
            getChange(money, price)
        }
        return "quit"
    }

    fun getMenu(): String? {
        println("============= Menu =============")
        println("|(1) 참꺠라면 - 1,000원    |")
        println("|(2) 햄버거 - 1,500원       |")
        println("|(3) 콜라 - 800원       |")
        println("|(4) 핫바 - 1,200원       |")
        println("|(5) 초코우유 - 1,500원       |")
        println("Choose menu: ")

        var menu = sc.nextLine()
        if(menu == "1"){
            println("참깨라면이 선택되었습니다.")
        } else if(menu == "2"){
            println("햄버거가 선택되었습니다.")
        } else if(menu == "3"){
            println("콜라가 선택되었습니다.")
        } else if(menu == "4"){
            println("핫바가 선택되었습니다.")
        } else if(menu == "5"){
            println("초코우유가 선택되었습니다.")
        } else {
            println("아무것도 선택되지 않았습니다.")
            println("다시 선택해주세요.")
            return null;
        }
        return menu;
    }

    fun getPrice(menu: Int): Int {
        when(menu){
            1 -> return 1000;
            2 -> return 1500;
            3 -> return 800;
            4 -> return 1200;
            5 -> return 1500;
            else -> return 0;
        }
    }
}

fun main(){
    var vendor = Vendor()

    var menu : String? = null;
    while(menu == null){
        menu = vendor.getMenu()
    }

    while(vendor.getCoin(menu) == null);
}