package Commands

import Drawing.Canvas

trait Command {
	def Execute(): Option[Canvas]
}
