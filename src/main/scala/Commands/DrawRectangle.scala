package Commands

import Canvas.Canvas
import Shapes.RectangleFactory

class DrawRectangle(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends CanvasCommand with Update[Canvas] {
	def Execute() {
		val points = RectangleFactory(x, y, x2, y2)
		canvas(points) = Canvas.Line
	}
}
