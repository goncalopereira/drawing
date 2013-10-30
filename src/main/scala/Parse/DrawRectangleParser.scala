package Parse

import Canvas.Canvas
import Commands.{Command, DrawRectangle}

class DrawRectangleParser extends Parser with CanvasRequired with OnlyIntArguments {
	def CanUse(t: Array[String]): Boolean = t.head == "R"

	def IsIncorrectNumberOfArguments(i: Int): Boolean = i != 4

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new DrawRectangle(parsed.is(0), parsed.is(1), parsed.is(2), parsed.is(3), canvas.get)
}
