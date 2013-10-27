package Commands

import Drawing.Canvas
import Shapes.LineFactory

class DrawLine(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] = {
		val points = LineFactory(x, y, x2, y2)
		canvas(points) = Canvas.Line
		Some(canvas)
	}
}
