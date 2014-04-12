import scala.collection.mutable.ArrayBuffer

/**
 * Created by sacry on 12/04/14.
 */

// A1
object ShortestRound {

  def distance(c1: Int, c2: Int) = 100 / (if (c1 > c2) (c1 - c2) else (c2 - c1))

  def shortestRound(cities: List[Int]) = cities.permutations.map(city =>
    (city, (1 to (city.size - 1)).foldLeft((city, 0)) {
      (acc, _) =>
        (acc._1.tail, acc._2 + distance(acc._1.head, acc._1.tail.head))
    }._2)
  ).minBy(_._2)

  def main(args: Array[String]) {
    val cities1 = (1 to 4).toList
    println(shortestRound(cities1))
    val cities2 = (1 to 3).toList
    println(shortestRound(cities2))
    val cities3 = (1 to 9).toList
    println(shortestRound(cities3))
    val cities4 = (1 to 1).toList
    println(shortestRound(cities4))
    val cities5 = List()
    println(shortestRound(cities5))
  }
}

// A2
object RunLengthEncoding {

  implicit class FancyList[A](val xs: List[A]) extends AnyVal {
    def group = {
      def group_acc[A](xs: List[A], acc: List[List[A]], tmp_acc: List[A], last: A): List[List[A]] = xs match {
        case xs if (xs.isEmpty) => tmp_acc :: acc
        case xs if (last == xs.head) => group_acc(xs.tail, acc, xs.head :: tmp_acc, last)
        case _ => group_acc(xs.tail, tmp_acc :: acc, xs.head :: List(), xs.head)
      }
      group_acc(xs, List(), List(), xs.head).reverse
    }
  }

  // cmp to Haskell version...
  // encode :: (Eq a) => [a] -> [(a, Int)]
  // encode [] = []
  // encode xs = map (\x -> (head x, length x)) (group xs)
  def encode(xs: List[Int]) = {
    xs.group.map(p => (p.head, p.size))
  }

  def rle_string(token: String): String = {
    token.foldLeft((new StringBuilder, 0, token(0)))((acc, c) => acc match {
      case (str, count, last) if (last == c) => (str, count + 1, last)
      case (str, count, last) => (str.append(count).append(last), 1, c)
    }).productIterator.mkString("")
  }

  def rle_list(token: List[Int]) = {
    token.foldLeft((ArrayBuffer[(Int, Int)](), 0, token(0)))((acc, c) => acc match {
      case (xs, count, last) if (last == c) => (xs, count + 1, last)
      case (xs, count, last) => (xs.+=((count, last)), 1, c)
    })._1.toList
  }

  def main(args: Array[String]) {
    val test1 = List(1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1)
    val test2 = "110111000110001010101010010"
    println(rle_list(test1))
    println(rle_string(test2))
    println(encode(test1))
  }
}

// A3
object A3 {

  def async[F](f: => F) = {
    val t = (new Thread(new Runnable() {
      def run() {
        f
      }
    }))
    t.start
    t
  }

  def mul(x: Int) = (y: Int) => x * y

  def main(args: Array[String]) {
    println(
      async {
        println("I am very sleepy")
        Thread.sleep(2000)
        println(mul(2)(-4))
      }
    )
    println(mul(8))
    println("stopped")
  }
}

// A4
case class Person(name: String)

trait Lecturer {
  def work = "I am lecturing"
}

trait Student {
  def work = "I am studying"
}

trait Worker {
  def work: String

  def act = work
}

class Person1(name: String) extends Person(name) with Student with Lecturer {
  override def work = super.work
}

class Person2(name: String) extends Person(name) with Lecturer with Student {
  override def work = super.work
}

object A4 {
  def main(args: Array[String]) {
    val pers3 = new Person("Müller") with Student with Lecturer with Worker {
      override def work = super[Student].work

      override val act = work + " I am working"
    }
    println(pers3 + ", " + pers3.act)
  }
}

// A5
trait Base {
  def act: String
}

trait Derived1 extends Base {
  abstract override def act = super.act + "Derived1 "
}

trait Derived2 extends Base {
  abstract override def act = super.act + "Derived2"
}

class BaseImpl extends Base {
  def act = "BaseImpl "
}

class Foo extends BaseImpl with Derived1 with Derived2

object A5 {
  def main(args: Array[String]) {
    println((new Foo).act)
  }
}