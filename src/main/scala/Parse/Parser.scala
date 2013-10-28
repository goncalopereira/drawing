package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
trait Parser {
	protected def ValidCanvas(canvas: Option[Canvas]): Boolean
	protected def ParserType(t: String): Boolean
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[Command]
	def Use(ss: Array[String], canvas: Option[Canvas]) = ValidCanvas(canvas) && ParserType(ss.head)
}

trait CanvasRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = canvas.nonEmpty
}

trait CanvasNotRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = true
}
