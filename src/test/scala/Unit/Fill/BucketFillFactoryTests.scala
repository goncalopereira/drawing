package Unit.Fill

import Canvas.Canvas
import Fill.BucketFillFactory
import org.specs2.mutable.Specification

class BucketFillFactoryTests extends Specification {

	val colour = 'c'
	val colour2 = 'a'

	val targetColour = None
	val canvas = new Canvas(5, 5)

	"Given a blank canvas" should {

		"When doing a step to a point to be coloured which has a side already to be coloured" in {

			val results = BucketFillFactory.Step((2, 1), targetColour, canvas, List((1, 1)), List((1, 2), (1, 0)))

			"Return list with all sides except that" in {
				results must beSome(List((3, 1), (2, 2), (2, 0)))
			}
		}

		"When doing a step to a point to be coloured which has a side already to on TODO" in {

			val results = BucketFillFactory.Step((2, 1), targetColour, canvas, List((1, 1)), List((1, 2), (1, 0),(2,0)))

			"Return list with all sides except that" in {
				results must beSome(List((3, 1), (2, 2)))
			}
		}

		"When doing the first step to fill" in {
			val results = BucketFillFactory.Step((1, 1), targetColour, canvas, List(), List())

			"Return list of sides to go next" in {
				results must beSome(List((0, 1), (2, 1), (1, 2), (1, 0)))
			}
		}

		"When doing second step to fill" in {
			val results = BucketFillFactory.Step((0, 1), targetColour, canvas, List((1, 1)), List((2, 1), (1, 2), (1, 0)))

			"Return none as it is not part of the canvas" in {
				results must beNone
			}
		}

		"When doing third step to fill" in {

			val results = BucketFillFactory.Step((2, 1), targetColour, canvas, List((1, 1)), List((1, 2), (1, 0)))

			"Return list with more sides to go next" in {
				results must beSome(List((3, 1), (2, 2), (2, 0)))
			}
		}

		"When using bucket fill in any point" in {
			"Fill all canvas" in {

				val points = BucketFillFactory(1, 1, canvas)

				canvas(points) = colour

				for (x <- 1 to 5; y <- 1 to 5) {
					canvas(x, y) mustEqual Some(colour)
				}
			}

			"Be able to re-fill all" in {
				val canvas = new Canvas(5, 5)

				val points = BucketFillFactory(1, 1, canvas)

				canvas(points) = colour2

				for (x <- 1 to 5; y <- 1 to 5) {
					canvas(x, y) mustEqual Some(colour2)
				}
			}
		}
	}

	"Given a canvas with lines" should {

		val lines = List((1, 2), (1, 3), (2, 3), (2, 4))

		"When using bucket fill in any point" in {

			val canvas = new Canvas(5, 5)

			canvas(lines) = colour

			val points = BucketFillFactory(3, 3, canvas)

			canvas(points) = colour2

			"Fill all unused canvas" in {

				val all = for (x <- 1 to 5; y <- 1 to 5) yield (x, y)

				all.diff(lines).foreach {
					case (x, y) => canvas(x, y) mustEqual Some(colour2)
				}
			}

			"Do not paint previous fills or lines" in {
				lines.foreach {
					case (x, y) => canvas(x, y) mustEqual Some(colour)
				}
			}
		}
	}
}

