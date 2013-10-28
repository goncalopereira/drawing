package Parse

import Canvas.Canvas
import Commands.Quit

class QuitParser extends Parser {
	def ParserType(t: Char): Boolean = t == 'Q'
	override def ValidCanvas(canvas: Option[Canvas]) = true
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[Quit] = Some(new Quit())
}
