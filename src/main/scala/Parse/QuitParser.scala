package Parse

import Canvas.Canvas
import Commands.Quit

class QuitParser extends Parser with CanvasNotRequired {
	def ParserType(t: String): Boolean = t == "Q"

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, Quit] = Right(new Quit())
}
