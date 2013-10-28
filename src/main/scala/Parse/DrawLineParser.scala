package Parse

import Canvas.Canvas
import Commands.{DrawLine, Command}

class DrawLineParser extends Parser with CanvasRequired with OnlyIntArguments {

	def ParserType(t: String): Boolean = t == "L"

	def CorrectNumberOfArguments(i: Int): Boolean = i == 4

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new DrawLine(parsed.is(0),parsed.is(1),parsed.is(2),parsed.is(3),canvas.get)
}
