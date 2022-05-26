package com.example.testapp.week3

import java.util.*
import kotlin.math.max

var N = 0
var M = 0
var arr = arrayOf(arrayOf(0))
var ans = 0

class Point(var x: Int, var y: Int)

fun buildWall(cnt : Int){
    if(cnt == 3){
        spreadVirus()
        return
    }

    for(i in 0..N-1){
        for(j in 0..M-1){
            if(arr[i][j] == 0){
                arr[i][j] = 1
                buildWall(cnt + 1)
                arr[i][j] = 0
            }
        }
    }
}

fun spreadVirus(){
    var moveX = arrayOf(-1, 1, 0, 0)
    var moveY = arrayOf(0, 0, -1, 1)

    var copyArr = Array(N, { Array(M, {0})})
    for(i in 0..N-1){
        for(j in 0..M-1){
            copyArr[i][j] = arr[i][j]
        }
    }

    var virusPoints : Queue<Point>
    virusPoints = LinkedList()

    for(i in 0..N-1){
        for(j in 0..M-1){
            if(copyArr[i][j] == 2){
                virusPoints.add(Point(i, j))
            }
        }
    }

    while(!virusPoints.isEmpty()){
        var p = virusPoints.remove()

        for (i in 0..3){
            var mX = p.x + moveX[i]
            var mY = p.y + moveY[i]

            if(mX >= 0 && mY >= 0 && mX < N && mY < M){
                if(copyArr[mX][mY] == 0){
                    copyArr[mX][mY] = 2
                    virusPoints.add(Point(mX, mY))
                }
            }
        }
    }

    calcSafe(copyArr)
}

fun calcSafe(copyArr: Array<Array<Int>>){
    var count = 0

    for(i in 0..N-1){
        for(j in 0..M-1){
            if(copyArr[i][j] == 0){
                count += 1
            }
        }
    }
    ans = max(ans, count)
}

fun main(){
    val sc : Scanner = Scanner(System.`in`)

    var line = sc.nextLine()
    N = line.split(" ")[0].toInt()
    M = line.split(" ")[1].toInt()
    arr = Array(N, { Array(M, {0})})

    for(i in 0..N-1){
        for(j in 0..M-1){
            arr[i][j] = sc.nextInt()
        }
    }
    buildWall(0)

    println(ans)
}