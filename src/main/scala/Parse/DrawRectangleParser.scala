package Parse

import Canvas.Canvas
import Commands.{Command, DrawRectangle}

class DrawRectangleParser extends Parser with CanvasRequired with OnlyIntArguments {

	def ParserType(t: String): Boolean = t == "R"

	protected def CorrectNumberOfArguments(i: Int): Boolean = i == 4

	protected def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new DrawRectangle(parsed.is(0), parsed.is(1), parsed.is(2), parsed.is(3), canvas.get)
}
