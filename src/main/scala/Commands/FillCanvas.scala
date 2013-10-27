package Commands

import Drawing.Canvas
import Fill.BucketFill

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] = {
		val points = BucketFill(x, y, colour, canvas)
		canvas(points) = colour
		Some(canvas)
	}
}
