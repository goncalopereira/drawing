package Drawing

/*
Abstracting line algorithm from Canvas and Draw
KISS because there are only two types of line, more variations could be replaced with Chain of Responsibility
No need to make a Line class and no space validation, it's a separate concept from Canvas
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

object RectangleFactory {
	def apply(x: Int, y: Int, x2: Int, y2: Int): Seq[(Int,Int)] = {

		/*Each side is a line*/
		val side1 = LineFactory(x,y,x2,y)
		val side2 = LineFactory(x,y,x,y2)
		val side3 = LineFactory(x,y2,x2,y2)
		val side4 = LineFactory(x2,y,x2,y2)

		val sides = side1 ++ side2 ++ side3 ++ side4

		/*sides overlap on corners*/
		sides.distinct
	}
}