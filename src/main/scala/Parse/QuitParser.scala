package Parse

import Canvas.Canvas
import Commands.{Command, Quit}

class QuitParser extends Parser with CanvasNotRequired {
	def ParserType(t: String): Boolean = t == "Q"

	def CorrectNumberOfArguments(i: Int): Boolean = true

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command = new Quit()

	def Parse(ss: Array[String]): Either[Boolean, ParseArguments] = Right(ParseArguments(Array(), None))
}
