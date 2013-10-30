package Commands

import Canvas.Canvas

class CreateCanvas(val width: Int, val height: Int) extends Command with Create[Canvas] {
	def Execute(): Canvas = new Canvas (width, height)
}
