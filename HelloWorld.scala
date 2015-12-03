import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.collection.mutable.HashMap
import scala.collection.immutable.SortedMap

object H{
   def sum(args : Int*) = {
     var result = 0
     for(arg <- args)
       result += arg
     result
}
   
   //递归计算字符串的unicode值
   def calculate(str : String,length : Int) : Long = {
     if (length == 1)
       str(length-1)
     else
       str(length-1) * calculate(str,length-1)
   }
   
   //生成一个长度为n的且元素为小于n的随机数的数组
   def createArray(n : Int) : Array[Int] = {
     var array = new Array[Int](n)
     for (i <- 0 until n)
       array(i) = scala.util.Random.nextInt(n)
     array
   }
   
   //倒序打印最终版
   def countdown(n : Int) : Unit = {
     for(i <- (0 to n).reverse)
         print(i + " ")
   }
   
   //倒序打印最初版
   def countdownVersion1(n : Int) : Unit = {
     for(i <- (0 to n);j = n - i)
       print(j + " ")
   }
   
   def newArray() : Array[Int] = {
     var array = new Array[Int](7)
     for(i <- 0 until 7)
       array(i) = scala.util.Random.nextInt(7)
     println(array.mkString("Array<",",",">"))
     var newArray = for(i <- (0 until 7).reverse) yield{
       array(i)
     }
     println(newArray.mkString("Array<",",",">"))
     null
   }
   
   def swapArrayByItself(n : Int) : Unit = {
     var array = new Array[Int](n)
     var temp = 0
     for(i <- 0 until n)
       array(i) = scala.util.Random.nextInt(n)
     println(array.mkString("Array<",",",">"))
     if(n % 2 == 0){
       for(i <- 0 until n if i % 2 == 0){
         temp = array(i)
         array(i) = array(i + 1)
         array(i + 1) = temp
       }
       println(array.mkString("Array<",",",">"))
     }else{
       if(n == 1){
         println(array.mkString("Array<",",",">"))
       }else{
         for(i <- 0 until n-1 if i % 2 == 0){
           temp = array(i)
           array(i) = array(i + 1)
           array(i + 1) = temp
         }
         println(array.mkString("Array<",",",">"))
       }
     }
   }
   
   def swapArrayByNewArray(n : Int) : Unit = {
     var array = new Array[Int](n)
     var temp = 0
     for(i <- 0 until n)
       array(i) = scala.util.Random.nextInt(n)
     println(array.mkString("Array<",",",">"))
     var result = for(i <- 0 until n) yield{
       if(n % 2 == 0){
         if(i % 2 == 0)
           array(i + 1)
         else
           array(i - 1)
       }else{
         if(i + 1 == n)
           array(i)
         else if(i % 2 == 0)
           array(i + 1)
         else
           array(i - 1)
       }
     }
     println(result.mkString("Array<",",",">"))
   }
   
   def sortArray() : Unit = {
     var a = Array(23,5,56,27,98,12)
     /*var b = a.sortWith(_ > _)*/
     scala.util.Sorting.quickSort(a) //该方法不适用于ArrayBuffer，因为不能对ArrayBuffer进行直接排序
     var b = for(i <- (0 until a.length).reverse) yield{
       a(i)
     }
     println(b.mkString("Array<", ",", ">"))
   }
   
   def sortMap() : Unit = {
     var scores = Map("Chengdu" -> 10,"Suining" -> 5,"Ya'an" -> 20)
     for((k,v) <- scores)
       println(v,k)
   }
   
   def countWords() : Unit = {
     var wordsList = Array("hello","blackmamba","hello","bryant","hello","hello","bryant")
     val countWord = new HashMap[String,Int]
     val map = Map[String,Int]()
     //var countWord = Map[String,Int]() //针对空的不可变Map的定义
     for(key <- wordsList)
       countWord(key) = countWord.getOrElse(key, 0) + 1
       //countWord = countWord + (key -> (countWord.getOrElse(key,0) + 1))//针对不可变Map对于映射的更新
     println(countWord.mkString(","))
   }
   
   def main(args: Array[String]) : Unit = {
     java2Scala
   }
     
}

class Person(var age : Int){
     private var a = 0
     def yourAge = a
     def yourAge_=(age : Int) : Unit = {
       if(age < 0) 
         a = 0 
       else 
         a = age
     }
   }

object Person{
  
}

object java2Scala{
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.HashMap
  
  val javaMap = new JavaHashMap[String,Int]()
  javaMap.put("Chengdu", 1)
  javaMap.put("Suining",2)
  javaMap.put("Yaan", 3)
  
  val scalaMap = new HashMap[String,Int]()
  for(key <- javaMap.keySet().toArray())
    scalaMap += (key.toString() -> javaMap.get(key))
  println(scalaMap.mkString(","))
}