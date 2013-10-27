package Shapes

/*
Flat representation of a Commands.Rectangle made by four lines which overlap in the corners
 */
object RectangleFactory {
	def apply(x: Int, y: Int, x2: Int, y2: Int) = {

		val sides = List((x, y, x2, y), (x, y, x, y2), (x, y2, x2, y2), (x2, y, x2, y2))

		val all = sides.flatMap {
			case (sX, sY, sX2, sY2) => LineFactory(sX, sY, sX2, sY2)
		}

		all.distinct
	}
}