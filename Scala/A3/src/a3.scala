/**
 * Created by sacry on 05/04/14.
 */

case class Polynom(args: Int*){
  def apply(x: Int)= ???
  def +(p:Polynom): Polynom = ???
  def *(p:Polynom): Polynom = ???
  def °(p:Polynom): Polynom = ???
  def toString= ???
}


object Polynom {

  def main(args:Array[String]){
    val zero= Polynom(0)
    val one= Polynom(0,0,0,1)
    val p1= Polynom(0,0,0,1,1)
    val p2= Polynom(4,3,2,1)
    val p3= Polynom(3,0,5)
    val p4= Polynom(-1,1,-10)
    val p5= Polynom((50,10))
  }
}
