package com.example.a1111

open class Mojaklasa (var pole1 : Int ) {
    var pole2 : Int? = null


    constructor (pole1: Int, pole2: Int?) : this (pole1){
        this.pole2 = pole2
    }
  open fun funkcja1 (p : Int) : Int {
      return p+1
  }
}
