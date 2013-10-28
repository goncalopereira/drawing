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
				println(points)

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

}