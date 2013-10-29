package Commands

import Canvas.Canvas
import Fill.BucketFillFactory

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas) extends CanvasCommand with Update[Canvas] {
	def Execute()  {
		val points = BucketFillFactory(x, y, canvas)
		canvas(points) = colour
	}
}
