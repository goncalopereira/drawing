package Shapes

object ShapeFactory {

	def Line(x: Int, y: Int, x2: Int, y2: Int) = { 
		(x, y, x2, y2) match {
			case (`x`, _, `x`, _) => (y to y2).map {
				case v => (x, v)
			}
			case (_, `y`, _, `y`) => (x to x2).map {
				case v => (v, y)
			}
			case _ => Seq[(Int, Int)]()
		}
	}
    
	def Rectangle(x: Int, y: Int, x2: Int, y2: Int): Seq[(Int,Int)] = {
	

		if (x == x2 || y == y2)
			return Seq[(Int, Int)]()

		val sides = List((x, y, x2, y), (x, y, x, y2), (x, y2, x2, y2), (x2, y, x2, y2))

		val all = sides.flatMap {
			case (sX, sY, sX2, sY2) => Line(sX, sY, sX2, sY2)
		}

		all.distinct
	}
  
}

