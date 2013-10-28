package Parse

import Canvas.Canvas
import Commands.CreateCanvas

class CreateCanvasParser extends Parser with CanvasNotRequired {

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, CreateCanvas] = {
		if (ss.length != 2)
			return Left(InputParser.WrongNumberOfArguments)

		var i: Array[Int] = Array[Int]()

		try {
			i = ss.map(_.toInt)
		}
		catch {
			case _ => return Left(InputParser.ParsingError)
		}

		Right(new CreateCanvas(i(0), i(1)))
	}

	def ParserType(t: String): Boolean = t == "C"
}
