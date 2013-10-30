package Parse

import Canvas.Canvas
import Commands.{DrawLine, Command}

class DrawLineParser extends Parser with CanvasRequired with OnlyIntArguments {
	def CanUse(t: Array[String]): Boolean = t.head == "L"

	def IsIncorrectNumberOfArguments(i: Int): Boolean = i != 4

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new DrawLine(parsed.convertedArguments(0), parsed.convertedArguments(1), parsed.convertedArguments(2), parsed.convertedArguments(3), canvas.get)
}
