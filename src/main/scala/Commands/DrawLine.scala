package Commands

import Canvas.Canvas
import Registry.Registry
import Shapes.ShapeFactory

class DrawLine(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas, service: ShapeFactory = Registry.shapeService)
	extends UpdateCanvasCommand {
	def Execute() {
		val points = service.Line(x, y, x2, y2)
		canvas(points) = Canvas.Line
	}
}
