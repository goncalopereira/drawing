import Canvas.Canvas
import Fill.BucketFillFactory
import org.specs2.mutable.Specification

class BucketFillFactoryTests extends Specification {

	val colour = 'c'
	val colour2 = 'a'

	"Given a blank canvas" should {

		"When using bucket fill in any point" in {
			"Fill all canvas" in {
				val canvas = new Canvas(5,5)

				val points = BucketFillFactory(1,1,colour,canvas)

				canvas(points) = colour

				for(x <- 1 to 5; y <- 1 to 5) {
					canvas(x,y) mustEqual Some(colour)
				}
			}

			"Be able to re-fill all" in {
				val canvas = new Canvas(5,5)

				val points = BucketFillFactory(1,1,colour2,canvas)

				canvas(points) = colour2

				for(x <- 1 to 5; y <- 1 to 5) {
					canvas(x,y) mustEqual Some(colour2)
				}
			}
		}
	}

	"Given a canvas with lines" should {

		val lines = List((1,2),(1,3),(2,3),(2,4))

		"When using bucket fill in any point" in {

			val canvas = new Canvas(5,5)

			canvas(lines) = colour

			val points = BucketFillFactory(3,3,colour2,canvas)

			canvas(points) = colour2

			"Fill all unused canvas" in {

				val all = for(x <- 1 to 5; y <- 1 to 5) yield (x,y)

				all.diff(lines).foreach  {
					case (x,y) => canvas(x, y) mustEqual Some(colour2)
				}
			}

			"Do not paint previous fills or lines" in {
				lines.foreach {
					case (x,y) => canvas(x, y) mustEqual Some(colour)
				}
			}
		}
	}
}

