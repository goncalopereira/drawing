package Parse

import Canvas.Canvas
import Commands.{Command, FillCanvas}

class FillCanvasParser extends Parser with CanvasRequired {

	def ParserType(t: String): Boolean = t == "B"

	protected def CorrectNumberOfArguments(i: Int): Boolean = i == 3

	protected def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command =
		new FillCanvas(parsed.is(0),parsed.is(1),parsed.colour.get,canvas.get)

	protected def Parse(ss: Array[String]) = {
		var i1, i2 = 0
		var colour: Char = ' '

		try {
			i1 = ss(0).toInt
			i2 = ss(1).toInt
			colour = ss(2).head
			Right(new ParseArguments(Array(i1,i2),Some(colour)))
		}
		catch {
			case _ => Left(false)
		}
	}
}
