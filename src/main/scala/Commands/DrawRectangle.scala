package Commands

import Canvas.Canvas
import Shapes.ShapeFactory
import Registry.Registry

class DrawRectangle(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas, service: ShapeFactory = Registry.shapeService) extends Command with Update[Canvas] {
	def Execute() {
		val points = service.Rectangle (x, y, x2, y2)
		canvas (points) = Canvas.Line
	}
}
