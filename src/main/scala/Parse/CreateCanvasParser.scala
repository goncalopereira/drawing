package Parse

import Canvas.Canvas
import Commands.{Command, CreateCanvas}

class CreateCanvasParser extends Parser with CanvasNotRequired with OnlyIntArguments {

	def CanUse(t: Array[String]): Boolean = t.head == "C"

	def IsIncorrectNumberOfArguments(i: Int): Boolean = i != 2

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new CreateCanvas(parsed.is(0), parsed.is(1))
}
