package Commands

import Canvas.Canvas
import Fill.BucketFillFactory
import Registry.Registry

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas, service: BucketFillFactory = Registry.fillService)
	extends UpdateCanvasCommand {
	def Execute() {
		val points = service(x, y, canvas)
		canvas(points) = colour
	}
}
