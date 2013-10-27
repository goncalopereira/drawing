package Commands

import Canvas.Canvas

trait Command {
	def Execute(): Option[Canvas]
}
