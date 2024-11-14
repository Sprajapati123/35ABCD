package com.example.basics

fun main() {
    // collection - list, set, map

//    var data = mutableMapOf(
//        "cat" to "This is animal",
//        "grapes" to "This is fruits",
//        "cabbage" to "This is vegetable"
//    )
//
//    println("Enter day of week")
//
//    var dayOfWeek : Int = readln().toInt()
//    var days : String
//
//    when(dayOfWeek){
//         1 -> days = "Sunday"
//         2 -> days = "Monday"
//         3 -> days = "Tuesday"
//        else -> days = "invalid days"
//    }
//    println(days)

    //in java
//    for(int i = 0;0<5;i++){
//        System.out.println(i)
//    }
//    in kotlin

    var data = listOf("ram","shyam")

//    for(int i : data){
//        System.out.println(i)
//    }
    data.forEach {
        println(it)
    }

    calculate(10,20)

}

//in java
/*
    void calculate(int a,int b){

    }
 */
fun calculate(a : Int,b: Int) : Unit{

}
