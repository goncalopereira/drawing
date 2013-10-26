package Drawing

/*
Abstracting line algorithm from Canvas and Draw
KISS because there are only two types of line, more variations could be replaced with Chain of Responsibility
*/
object LineFactory {
		def apply(x: Int, y: Int, x2: Int, y2: Int): Seq[(Int,Int)] = {

		/*Horizontal Line*/
		if (x == x2)
			 return (y to y2).map {
				case v => (x, v)
		}

		/*Vertical Line*/
		if (y == y2)
			return (x to x2).map {
			case v => (v, y)
		}

		/*No results*/
	 Seq[(Int,Int)]()
	}
}
