package recfun

object Main {
	def main(args: Array[String]) {
		println("Pascal's Triangle")
		for (row <- 0 to 10) {
			for (col <- 0 to row)
				print(pascal(col, row) + " ")
			println()
		}
	}

	/**
	 * Exercise 1
	 */
	def pascal(c: Int, r: Int): Int = {
		if (0 == c || c == r) 1
		else pascal(c - 1, r - 1) + pascal(c, r - 1)
	}

	/**
	 * Exercise 2
	 */

	def balance(chars: List[Char]) =
	{
		val newc = for (c <- chars.toArray) yield c.toInt
		for (c <- 0 until newc.length) {
			if (newc(c) == 40) newc(c) = 1
			else if (newc(c) == 41) newc(c) = -1
			else newc(c) = 0
		}
		if ((newc.length == 1 && newc(0) == 1) || (newc.length == 1 && newc(0) == -1)) false
		else if (newc.length == 0) true
		else {
			if (newc(newc.length - 1) == 1) false
			else if (newc(0) == -1) false
			else {
				for (i <- 0 until newc.length - 1) {
					newc(i + 1) += newc(i)
					if (newc(i + 1) == -1) newc(0) = -2
				}
				if (newc(0) == -2) false
				else true
			}
		}
	}
/*	def balance(chars: List[Char]): Boolean ={
		def count(char:Char):Int ={
			if (char == '(') 1
			else if (char == ')') -1
			else 0
		}
		def isOK(len:Int,chars:List[Char]):Boolean={
			if (chars.isEmpty) len==0
			else if (len==0 && count(chars.head) == -1) false
			else isOK(len+count(chars.head),chars.tail)
		}
		isOK(0,chars)
	}*/

	/**
	 * Exercise 3
	 */
	def countChange(money: Int, coins: List[Int]): Int = {
		if (0 == money) 1
		else if (coins.isEmpty) 0
		else if (money < 0) 0
		else countChange(money, coins.tail) + countChange(money - coins.head, coins)
	}
}
