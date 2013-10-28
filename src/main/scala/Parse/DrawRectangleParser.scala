package Parse

import Canvas.Canvas
import Commands.DrawRectangle

class DrawRectangleParser extends Parser with CanvasRequired {

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, DrawRectangle] = {
		if (!ValidCanvas(canvas))
			return Left(InputParser.RequireCanvas)

		if (ss.length != 4)
			return Left(InputParser.WrongNumberOfArguments)

		var i: Array[Int] = Array[Int]()

		try {
			i = ss.map(_.toInt)
		}
		catch {
			case _ => return Left(InputParser.ParsingError)
		}

		Right(new DrawRectangle(i(0), i(1), i(2), i(3), canvas.get))
	}

	def ParserType(t: String): Boolean = t == "R"
}
