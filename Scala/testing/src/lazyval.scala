/**
 * Created by sacry on 07/04/14.
 */


object Lazyval {
  var count1 = 0
  var count2 = 0
  lazy val fi = (xs: List[Int], p: (Int => Boolean)) => {
    count1+=1
    xs.filter(p)
  }
  lazy val ma = (xs: List[Int], p: (Int => Int)) => {
    count2+=1
    xs.map(p)
  }

  def main(args: Array[String]){
    lazy val l = List(1,2,3,4,5,10,10,10,10,10)
    lazy val res = ma(ma(l, p => p + 1), p => p + 2)
    println(res)
    println("List Length: " + l.length)
    println("Total iteration count: " + (count1 + count2) * l.length)
  }

}

