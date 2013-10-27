package test.scala

import org.specs2.mutable.Specification
import Shapes.LineFactory

class LineFactoryTests extends Specification {

	"Given two points not on same line" should {
		val x = 1
		val y = 2
		val x2 = 2
		val y2 = 3

		"When building a line" in {
			var results = LineFactory(x,y,x2,y2)

			"Then return no results" in {
				results must have size(0)
			}
		}
	}

	"Given two points on horizontal line" should {
		val x = 1
		val y = 3
		val y2 = 6

		"When building a line" in {
			var results = LineFactory(x,y,x,y2)

			"Then return correct number of points in line" in {
				results must have size(4)
			}

			"Then return points from first to second" in {
				results must contain((x,3))
				results must contain((x,4))
				results must contain((x,5))
				results must contain((x,6))
			}
		}
	}

	"Given two points on vertical line" should {
		val x = 1
		val x2 = 4
		val y = 3

		"When building a line" in {
			var results = LineFactory(x,y,x2,y)

			"Then return correct number of points in line" in {
				results must have size(4)
			}

			"Then return points from first to second" in {
				results must contain((1,y))
				results must contain((2,y))
				results must contain((3,y))
				results must contain((4,y))
			}
		}
	}

}