package Unit.Shapes

import org.specs2.mutable.Specification
import Shapes.RectangleFactory

class RectangleFactoryTests extends Specification {

	"Two points on same horizontal line" should {
		val x = 1
		val y = 2
		val y2 = 3

		"When building a rectangle" in {

			var results = RectangleFactory(x, y, x, y2)

			"Then return no results" in {
				results must have size (0)
			}
		}
	}

	"Two points on same vertical line" should {
		val x = 1
		val x2 = 4
		val y = 3

		"When building a rectangle" in {

			var results = RectangleFactory(x, y, x2, y)

			"Return no results" in {
				results must have size (0)
			}
		}
	}

	"Two points not on same line" should {
		val x = 1
		val y = 2
		val x2 = 2
		val y2 = 3

		"When building a rectangle" in {
			var results = RectangleFactory(x, y, x2, y2)

			"Return correct number of points" in {
				results must have size (4)
			}

			"Not contain duplicates for corners" in {
				results.distinct must have size (4)
			}

			"Return all points" in {
				results must contain((x, y))
				results must contain((x, y2))
				results must contain((x2, y))
				results must contain((x2, y2))
			}
		}
	}
}
