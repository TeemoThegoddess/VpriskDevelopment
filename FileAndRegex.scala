class People(val name : String) extends Serializable{
  import scala.collection.mutable.ArrayBuffer

  var friends = new ArrayBuffer[People]()
  
  def addFriend(people : People) : Unit = {
    friends += people
  }
  
  override def toString() : String = {
    var str = name + "'s friends are "
    for(friend <- friends)
      str += friend.name + " "
    str
  }
}

object People{
  import java.io.{FileInputStream,FileOutputStream,ObjectInputStream,ObjectOutputStream}
  
  def writeToFile(fileName : String,people : People) : Unit = {
    val out = new ObjectOutputStream(new FileOutputStream(fileName))
    out.writeObject(people)
    out.close()
  }
  
  def readFromFile(fileName : String) : People = {
    val in = new ObjectInputStream(new FileInputStream(fileName))
    in.readObject().asInstanceOf[People]
  }  
}

class FileUtils{
  import java.io.File
  
  //目录及其子目录中以class结尾的文件迭代器
  def subdirs(dir : File) : Iterator[File] = {
    val children = dir.listFiles().filter(_.getName.endsWith("class"))
    children.toIterator ++ dir.listFiles().filter(_.isDirectory()).toIterator.flatMap(subdirs _)
  }
}

class FileOperate{
  import io.Source
  import java.io.PrintWriter
  import scala.collection.mutable.ArrayBuffer
  import math._
  
  def reverseContent(fileName : String) : Unit = {
    val newFileContent = Source.fromFile(fileName).getLines().toArray.reverse
    val pw = new PrintWriter(fileName)
    for(i <- 0 until newFileContent.length)
      pw.write(newFileContent(i))
    pw.close()
  }
  
  def printStr(fileName : String) : Unit = {
    for(elem <- Source.fromFile(fileName).mkString.split("\\s+") if elem.length() > 12) println(elem)
  }
  
  def printNum(fileName : String) : Unit = {
    val fileContent = Source.fromFile(fileName).mkString.split("\\s+")
    var total : Double = 0d
    val numList = new ArrayBuffer[Double]
    for(elem <- fileContent){
         numList += elem.toDouble
         total += elem.toDouble
      }
    println("Total = " + total)
    println("Average = " + total/numList.length)
    println("Max num = " + numList.max)
    println("Min num = " + numList.min)
  }
  
  def writeNum(fileName : String) : Unit = {
    val pw = new PrintWriter(fileName)
    for(i <- 0 to 20){
      val num = pow(2,i)
      pw.write(num.toString())
      pw.write("\t\t")
      pw.write((1/num).toString())
      pw.write("\n")
    }
    pw.close()
  }
}

object test9 extends App{
  val p1 = new People("fc")
  val p2 = new People("wfw")
  val p3 = new People("lj")
  
  p1.addFriend(p2)
  p1.addFriend(p3)
  println(p1)
  

  val p = People.readFromFile("D:\\Eclipse\\Workspace\\HelloWorld\\src\\file.txt")
  println(p)
}