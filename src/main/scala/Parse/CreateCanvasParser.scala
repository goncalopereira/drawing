package Parse

import Canvas.Canvas
import Commands.{Command, CreateCanvas}

class CreateCanvasParser extends Parser with CanvasNotRequired with OnlyIntArguments {
	def CanUse(arguments: Array[String]): Boolean = arguments.head == "C"

	def IsIncorrectNumberOfArguments(numberArguments: Int): Boolean = numberArguments != 2

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new CreateCanvas(parsed.convertedArguments(0), parsed.convertedArguments(1))
}
