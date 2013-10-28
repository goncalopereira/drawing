package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
trait Parser {
	def ValidCanvas(canvas: Option[Canvas]): Boolean
	def ParserType(t: Char): Boolean
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[Command]
}

trait CanvasRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = canvas.nonEmpty
}

trait CanvasNotRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = true
}