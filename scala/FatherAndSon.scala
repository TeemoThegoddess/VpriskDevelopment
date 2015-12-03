/*
class BankAccount(initialBalance : Double){
  private var balance = initialBalance
  
  def deposit(amount : Double) : Double = {
    balance += amount
    balance
  }
  
  def withdraw(amount : Double) : Double = {
    balance -= amount
    balance
  }
}

class CheckAccount(initialBalance : Double) extends BankAccount(initialBalance){
  
  override def deposit(amount : Double) : Double = {
    super.deposit(amount - 1)
  }
  
  override def withdraw(amount : Double) : Double = {
    super.deposit(amount - 1)
  }
}

object CheckAccount{
  def apply(initialBalance : Double) : CheckAccount = {
    new CheckAccount (initialBalance)
  }
}

class SavingAccount(initialBalance : Double) extends BankAccount(initialBalance){
 
  private var num : Int = _
  
  def earnMonthlyInterest() : Double = {
    num = 3
    super.deposit(1)
  }
  
  override def deposit(amount : Double) : Double = {
    num -= 1
    if(num < 0)
      super.deposit(amount - 1)
    else
      super.deposit(amount)
  }
  
  override def withdraw(amount : Double) : Double = {
    num -= 1
    if(num < 0)
      super.withdraw(amount - 1)
    else
      super.withdraw(amount)
  }
}*/

class Point(x : Double,y : Double){
  
}

class LabeledPoint(label : String,x : Double,y : Double) extends Point(x,y){
  
}

abstract class Item{
  def price : Double
  def description : String
  
  override def toString() : String = {
    "Price is " + price + " Description is " + description
  }
}

class SimpleItem(override val price : Double,override val description : String) extends Item{}

class Bundle extends Item{
  import scala.collection.mutable.ArrayBuffer
  
  val items = new ArrayBuffer[Item]
  
  def addItem(item : Item) : Unit = {
    items += item
  }
  
  def price : Double = {
    var total = 0d
    for(elem <- items)
      total += elem.price
    total
  }
  
  def description : String = {
    items.mkString(",")
  }
}


object test1 extends App{

}