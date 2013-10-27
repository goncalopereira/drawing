package Commands

import Drawing.Canvas
import Fill.BucketFillFactory

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] = {
		val points = BucketFillFactory(x, y, colour, canvas)
		canvas(points) = colour
		Some(canvas)
	}
}