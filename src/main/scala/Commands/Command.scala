package Commands

import Canvas.Canvas

abstract class Command {
	def Execute(): Option[Canvas]
}
