package com.example.testapp

import java.util.*

enum class RANK{A, B, C, D, E, F}

class MyAccount(private var name:String, private var money:Int, private var rank: RANK){
    var locked = false

    fun printInfo(){
        println("계좌 정보는 다음과 같습니다")
        println("|이름:     $name|")
        println("|계좌잔액:  $money  |")
        println("|신용등급:  ${rank}  |")
        println("----------------")
        println()
        println()
    }

    fun deposite(amount : Int){
        money += amount
        if(money >= 0){
            if(locked){
                locked = false
                println("동결계좌가 열렸습니다.")
            }
            upGrade()
        }
        println("$amount 원을 입금하였습니다. 잔액 : $money")
    }

    fun withdraw(amount: Int) {
        money -= amount
        if(rank == RANK.F) {
            locked = true
            println("최저 등급의 신용을 가지고 있습니다.")
            println("계좌가 동결됩니다.")
        }

        if(money < 0 && money >= -1000){
            println("계좌가 마이너스 되었습니다.")
            downGrade()
        } else if (money < -1000) {
            println("잔액이 부족합니다.")
        }
        println("$amount 원을 출금하였습니다. 잔액 : $money")
    }

    fun downGrade() {
        var prevRank = rank
        if(rank == RANK.A){
            rank = RANK.B
        } else if(rank == RANK.B) {
            rank = RANK.C
        } else if(rank == RANK.C) {
            rank = RANK.D
        } else if(rank == RANK.D) {
            rank = RANK.E
        } else if(rank == RANK.E) {
            rank = RANK.F
        } else {
            return
        }
        println("신용등급이 \'${prevRank}->${rank}\'로 한단계 떨어집니다.")
    }

    fun upGrade(){
        var prevRank = rank
        if(rank == RANK.B){
            rank = RANK.A
        } else if(rank == RANK.C) {
            rank = RANK.B
        } else if(rank == RANK.D) {
            rank = RANK.C
        } else if(rank == RANK.E) {
            rank = RANK.D
        } else if(rank == RANK.F) {
            rank = RANK.E
        }
        println("신용등급이 \'${prevRank}->${rank}\'로 한단계 상승합니다.")
    }
}

fun main() {
    val sc : Scanner = Scanner(System.`in`)

    var mode = String()
    var account = MyAccount("Kim", 0, RANK.C)

    while(true){
        println("----선택하세요----")
        println("|(I) 계좌정보    |")
        println("|(D) 입금       |")
        println("|(W) 출금       |")
        println("|(E) 종료       |")
        println("----------------")
        mode = sc.nextLine()

        if(mode == "I"){
            account.printInfo()
        } else if (mode == "D") {
            println("입금하실 금액을 말하세요.")
            var amount = sc.nextInt()
            sc.nextLine()
            account.deposite(amount)
        } else if (mode == "W") {
            if(account.locked) {
                println("동결된 계좌에서 출금하실 수 없습니다.")
                continue
            }
            println("출금하실 금액을 말하세요.")
            var amount = sc.nextInt()
            sc.nextLine()
            account.withdraw(amount)
        } else if(mode == "E") {
            break
        }
    }
}