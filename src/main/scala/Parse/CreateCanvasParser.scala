package Parse

import Canvas.Canvas
import Commands.{Command, CreateCanvas}

class CreateCanvasParser extends Parser with CanvasNotRequired with OnlyIntArguments {

	def ParserType(t: String): Boolean = t == "C"

	protected def CorrectNumberOfArguments(i: Int): Boolean = i == 2

	protected def CreateCommand(parsed: ParseArguments,canvas: Option[Canvas]): Command =
		new CreateCanvas(parsed.is(0),parsed.is(1))
}
