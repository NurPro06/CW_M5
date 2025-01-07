package com.example.cw_m5

class CounterModel {
    private var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun getResult() = count.toString()

    fun isCountTen() = count == 10

    fun isCountFifteen() = count == 15
}