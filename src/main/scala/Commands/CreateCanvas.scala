package Commands

import Canvas.Canvas

class CreateCanvas(val width: Int, val height: Int) extends Command {
	def Execute(): Option[Canvas] = {
		Some(new Canvas(width, height))
	}
}
