package Parse

import Canvas.Canvas
import Commands.{Command, FillCanvas}

class FillCanvasParser extends Parser with CanvasRequired {
	def CanUse(arguments: Array[String]): Boolean = arguments.head == "B"

	def IsIncorrectNumberOfArguments(i: Int): Boolean = i != 3

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new FillCanvas(parsed.convertedArguments(0), parsed.convertedArguments(1), parsed.colour.get, canvas.get)

	def TryParse(arguments: Array[String]) = {
		var i1, i2 = 0
		var colour: Char = ' '

		try {
			i1 = arguments(0).toInt
			i2 = arguments(1).toInt
			colour = arguments(2).head
			Right(new ParseArguments(Array(i1, i2), Some(colour)))
		} catch {
			case _ => Left(false)
		}
	}
}
