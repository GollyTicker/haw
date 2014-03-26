import scala.annotation.tailrec;

// Tail Recursive Optimized Array Version..
def collatz(n: Int): Array[Int] = {
	@tailrec def collatz_tail(x: Int, accu: Array[Int]): Array[Int] = x match {
    case 1 => accu :+ 1 // O(?)
    case x if x % 2 == 0 => collatz_tail(x / 2, accu :+ x)
    case _ => collatz_tail(3 * x + 1, accu :+ x)
  }
  collatz_tail(n, Array())
}

// Tail Recursive Optimized ArrayBuffer Version..
def collatz_arr_buffer(n: Int): Array[Int] = {
  @tailrec def collatz_tail(x: Int, accu: ArrayBuffer[Int]): ArrayBuffer[Int] = x match {
    case 1 => accu += 1 // O(1)
    case x if x % 2 == 0 => collatz_tail(x / 2, accu += x)
    case _ => collatz_tail(3 * x + 1, accu += x)
  }
  collatz_tail(n, new ArrayBuffer[Int]).toArray
}

// Simple List Recursion
def collatz_rec(n: Int): List[Int] = n match {
    case 1 => List(1)
    case n if n % 2 == 0 => n :: collatz_rec(n / 2)
    case _ => n :: collatz_rec(3 * x + 1)
  }
}
