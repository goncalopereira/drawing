package Unit.Tests

import Canvas.Canvas
import org.specs2.mutable.Specification

class CanvasTests extends Specification {

	"A width and a length" should {
		val width = 8
		val height = 7

		"When building a Canvas" in {

			val canvas = new Canvas(width, height)

			"Have correct width" in {
				canvas(0) must have size (width + 2)
			}
			"Have correct height" in {
				canvas must have size (height + 2)
			}
			"Have empty points" in {
				canvas(1, 1) mustEqual None
			}
			"Print correctly" in {
				canvas.toString mustEqual "----------\n|        |\n|        |\n|        |\n|        |\n|        |\n|        |\n|        |\n----------\n"
			}
		}

		"When updating a Canvas" in {
			val updateCanvas = new Canvas(width, height)

			"Update correctly in matrix" in {
				updateCanvas(1, 1) = 'x'
				updateCanvas(1, 1) mustEqual Some('x')
			}
			"Not allow to update borders" in {
				updateCanvas(0, 0) = 'x'
				updateCanvas(0, 0) mustEqual Some('-')
				updateCanvas(width, height) = 'x'
				updateCanvas(width + 1, height + 1) mustEqual Some('-')
			}
		}
	}
}
