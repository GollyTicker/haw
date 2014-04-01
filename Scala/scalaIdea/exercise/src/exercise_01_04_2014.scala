import scala.util.Random

/**
 * Created by sacry on 01/04/14.
 */

object StringGenerator {
  def intG(from: Int, to: Int) = from + Random.nextInt(to - 1)

  def intToChar(from: Int, to: Int) = intG(from, to).asInstanceOf[Char]

  def rdmRange(min: Int, max: Int) = 0 to intG(min, max)

  def generate(min: Int, max: Int, from: Int, to: Int) = (for (e <- rdmRange(min, max)) yield intToChar(from, to)).mkString("")

  def gFold(min: Int, max: Int, from: Int, to: Int) = rdmRange(min, max).foldLeft("")((a, _) => a + intToChar(from, to))

  def main(args: Array[String]) {
    println(StringGenerator.generate(min = 5, max = 15, from = 0, to = 128))
    println(StringGenerator.gFold(min = 5, max = 15, from = 0, to = 128))
    println(StringGenerator.gFold(5, 15, 60, 90))
  }
}

object sumProds {

  def sumOfprods(l1: List[Int], l2: List[Int]) = {
    l1.zip(l2).foldLeft(0)((accu, t) => accu + (t._1 * t._2))
  }

  def sumOfprods2(l1: List[Int], l2: List[Int]) = {
    l1.foldLeft((l2, 0))((t3, e) => (t3._1.tail, t3._2 + (t3._1.head * e)))._2
  }

  def product(l1: List[Int], l2: List[Int]) = {
    l1.zip(l2).map(t => t._1 * t._2)
  }

  def main(args: Array[String]) {
    val c = sumOfprods(List(1, 2, 3, 4), List(1, 2, 3, 4))
    println(c)
    val c2 = sumOfprods2(List(1, 2, 3, 4), List(1, 2, 3, 4, 4))
    println(c2)
    val d = product(List(1, 2, 3), List(1, 2, 3, 4))
    println(d)
  }

}

case class Person private(val name: String, var age: Int = 0, private val pw: String = StringGenerator.generate(min = 5, max = 15, 65, 90)) {
  override def toString = "Person(" + name + ", " + age + ")"
}

object Person {
  def main(args: Array[String]) {
    val p = Person("matze", 26)
    println(p)
    println(p.pw)
  }
}

class User(val name: String)

trait AnyMail {
  def provider = "<domain>.<country>"

  def user: String

  def address = "any" + "@?" + provider
}

trait GMail extends AnyMail {
  override val provider = "gmail.com"
  override val user: String

  override def address = user + "@" + provider
}

trait Bank {
  def account: Long
}

case class Costumer(override val name: String, override val account: Long) extends User(name) with GMail with Bank {
  val user = name
  override val address = super.address

  override def toString = "Costumer(" + user + ", " + address + ", " + account + ")"
}

object CostumerTest {
  def main(args: Array[String]) {
    val c = Costumer("Matthias", 1234567L)
    println(c)
  }
}


object LambdaTest {
  def main(args: Array[String]) {
    println("This")
  }
}
