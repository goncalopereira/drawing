package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
trait Parser {
	protected def ValidCanvas(canvas: Option[Canvas]): Boolean

	protected def ParserType(t: String): Boolean

	protected def CorrectNumberOfArguments(i: Int): Boolean

	protected def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command

	protected def Parse(ss: Array[String]): Either[Boolean,ParseArguments]

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, Command] = {
		if (!ValidCanvas(canvas))
			return Left(InputParser.RequireCanvas)

		if (!CorrectNumberOfArguments(ss.length))
			return Left(InputParser.WrongNumberOfArguments)

		val parsing: Either[Boolean, ParseArguments] = Parse(ss)

		if (parsing.isLeft)
			return Left(InputParser.ParsingError)

		Right(CreateCommand(parsing.right.get,canvas))
	}

	def Use(ss: Array[String]) = ParserType(ss.head)
}

trait CanvasRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = canvas.nonEmpty
}

trait CanvasNotRequired {
	def ValidCanvas(canvas: Option[Canvas]): Boolean = true
}

trait OnlyIntArguments {
	protected def Parse(ss: Array[String]): Either[Boolean,ParseArguments] = {
		try {
			val i = ss.map(_.toInt)
			Right(new ParseArguments(i, None))
		}
		catch {
			case _ => return Left(false)
		}
	}
}

case class ParseArguments(is: Array[Int],colour: Option[Char])
