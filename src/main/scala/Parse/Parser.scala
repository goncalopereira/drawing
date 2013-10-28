package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
trait Parser {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = canvas match { case Some(c) => true; case None => false }
	def ParserType(t: Char): Boolean
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[Command]
}
