package Shapes
/*
Flat representation of a Commands.Rectangle made by four lines which overlap in the corners
 */
object RectangleFactory {
	def apply(x: Int, y: Int, x2: Int, y2: Int): Seq[(Int,Int)] = {

		val side1 = LineFactory(x,y,x2,y)
		val side2 = LineFactory(x,y,x,y2)
		val side3 = LineFactory(x,y2,x2,y2)
		val side4 = LineFactory(x2,y,x2,y2)

		val sides = side1 ++ side2 ++ side3 ++ side4

		sides.distinct
	}
}