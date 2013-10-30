package Parse

import Canvas.Canvas
import Commands.{Command, DrawRectangle}

class DrawRectangleParser extends Parser with CanvasRequired with OnlyIntArguments {
	def CanUse(arguments: Array[String]): Boolean = arguments.head == "R"

	def IsIncorrectNumberOfArguments(numberArguments: Int): Boolean = numberArguments != 4

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new DrawRectangle(parsed.convertedArguments(0), parsed.convertedArguments(1), parsed.convertedArguments(2), parsed.convertedArguments(3), canvas.get)
}
