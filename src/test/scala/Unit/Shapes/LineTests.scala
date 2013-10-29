package test.scala.Unit.Shapes

import org.specs2.mutable.Specification
import Shapes.ShapeFactory

class LineTests extends Specification {

	"Two points not on same line" should {
		val x = 1
		val y = 2
		val x2 = 2
		val y2 = 3

		"When building a line" in {
			var results = ShapeFactory.Line(x, y, x2, y2)

			"Return no results" in {
				results must have size (0)
			}
		}
	}

	"Two points on horizontal line" should {
		val x = 1
		val y = 3
		val y2 = 6

		"When building a line" in {
			var results = ShapeFactory.Line(x, y, x, y2)

			"Return correct number of points in line" in {
				results must have size (4)
			}

			"Return points from first to second" in {
				results must contain((x, 3))
				results must contain((x, 4))
				results must contain((x, 5))
				results must contain((x, 6))
			}
		}
	}

	"Two points on vertical line" should {
		val x = 1
		val x2 = 4
		val y = 3

		"When building a line" in {
			var results = ShapeFactory.Line(x, y, x2, y)

			"Return correct number of points in line" in {
				results must have size (4)
			}

			"Return points from first to second" in {
				results must contain((1, y))
				results must contain((2, y))
				results must contain((3, y))
				results must contain((4, y))
			}
		}
	}

}
