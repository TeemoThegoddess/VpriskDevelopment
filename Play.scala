package random{
  package object random{
    var seed : Int = _
    val a = BigDecimal(1664525)
    val b = BigDecimal(1013904223)
    val n = 32
  
    import math._
    def nextInt() : Int = {
      val temp = (seed * a + b) % pow(2,32)
      temp.toInt
    }
    
    def nextDouble() : Double = {
       val temp = (seed * a + b) % pow(2,32)
       temp.toDouble
    }
  }
}

import random.random._
    object test extends App{
    seed = 4
    val a = nextInt()
    val b = nextDouble()
    println()
  }
