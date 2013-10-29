package Commands

import Canvas.Canvas
import Shapes.ShapeFactory

class DrawLine(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command with Update[Canvas] {
	def Execute() {
		val points = ShapeFactory.Line(x, y, x2, y2)
		canvas(points) = Canvas.Line
	}
}
