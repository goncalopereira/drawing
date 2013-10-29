package Commands

import Canvas.Canvas
import Fill.BucketFillFactory

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] = {
		val points = BucketFillFactory(x, y, canvas)
		canvas(points) = colour
		Some(canvas)
	}
}
