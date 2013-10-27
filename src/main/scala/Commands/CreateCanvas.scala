package  Commands

import Drawing.Canvas

class CreateCanvas(width: Int, height: Int) extends Command {
	def Execute(): Option[Canvas] = {
		Some(new Canvas(width, height))
	}
}
