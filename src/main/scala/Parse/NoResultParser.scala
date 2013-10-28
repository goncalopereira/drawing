package Parse

import Canvas.Canvas
import Commands.Command

class NoResultParser extends Parser {
	def ParserType(t: Char): Boolean = true
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[Command] = None
}
