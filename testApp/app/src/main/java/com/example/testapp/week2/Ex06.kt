package com.example.testapp.week2

class Calculator(){
    private var history : MutableList<Double> = mutableListOf()
    
    private fun add(a : Double, b: Double):Double{
        return a + b
    }

    private fun subtract(a : Double, b: Double):Double{
        return a - b
    }

    private fun multiple(a : Double, b: Double):Double{
        return a * b
    }

    private fun division(a : Double, b: Double):Double{
        return a / b
    }
    
    fun load(){
        history.iterator().forEach { println(it) }
    }
    
    fun cal(a : Double, b: Double, type : String) {
        if(type.equals("add")){
         history.add(add(a,b))   
        } else if(type.equals("subtract")) {
            history.add(subtract(a,b))
        } else if(type.equals("division")) {
            if(b.equals(0.0)){
                println("ERROR : number can not be divided with zero.")
            } else {
                history.add(division(a,b))
            }
        } else {
            history.add(multiple(a,b))
        }
    }
    
    fun print_calculated_number(){
        println(history.get(history.size-1))
    }
}

fun main(){
    var calculator = Calculator()
    calculator.cal(1.0, 2.0, "add")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0, 0.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "division")
    calculator.print_calculated_number()
    calculator.cal(1.0, 10.0, "multiple")
    calculator.print_calculated_number()
    println("-------------------")
    calculator.load()
}