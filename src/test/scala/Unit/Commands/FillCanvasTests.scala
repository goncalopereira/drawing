package Unit.Commands

import org.specs2.mutable.Specification
import Commands._
import Fill._
import org.specs2.mock.Mockito
import Canvas._

class FillCanvasTests extends Specification with Mockito {
	val service = mock[BucketFillFactory]
	val line = List((1, 1))
	val colour = 'o'
	val canvas = mock[Canvas]
	service(1, 2, canvas) returns line

	"FillCanvasCommand" should {
		val draw = new FillCanvas(1, 2, colour, canvas, service)

		"When executed" in {
			draw.Execute()

			one(service).apply(1, 2, canvas)

			"Updates the Canvas" in {
				one(canvas).update(line, colour)
			}
		}
	}
}

