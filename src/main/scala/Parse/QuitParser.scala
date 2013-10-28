package Parse

import Canvas.Canvas
import Commands.{Command, Quit}

class QuitParser extends Parser with CanvasNotRequired {
	def ParserType(t: String): Boolean = t == "Q"

	protected def CorrectNumberOfArguments(i: Int): Boolean = true

	protected def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command = new Quit()

	protected def Parse(ss: Array[String]): Either[Boolean, ParseArguments] = Right(ParseArguments(Array(),None))
}
