package Commands

import Canvas.Canvas

class CreateCanvas(val width: Int, val height: Int) extends CreateCanvasCommand {
	def Execute(): Canvas = new Canvas(width, height)
}
