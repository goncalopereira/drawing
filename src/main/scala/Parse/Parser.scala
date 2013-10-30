package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
abstract class Parser {
	def ValidCanvas(canvas: Option[Canvas]): Boolean

	def ParserType(t: String): Boolean

	def CorrectNumberOfArguments(i: Int): Boolean

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command

	def Parse(ss: Array[String]): Either[Boolean, ParseArguments]

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, Command] = {

		if (!ValidCanvas(canvas))
			return Left(ParserService.RequireCanvas)

		if (!CorrectNumberOfArguments(ss.length))
			return Left(ParserService.WrongNumberOfArguments)

		val parsing: Either[Boolean, ParseArguments] = Parse(ss)

		if (parsing.isLeft)
			return Left(ParserService.ParsingError)

		Right(CreateCommand(parsing.right.get, canvas))
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
	def Parse(ss: Array[String]): Either[Boolean, ParseArguments] = {
		try {
			val i = ss.map(_.toInt)
			Right(new ParseArguments(i, None))
		}
		catch {
			case _ => return Left(false)
		}
	}
}

trait NoArguments {
	def Parse(ss: Array[String]) = Right(ParseArguments(Array(), None))

	def CorrectNumberOfArguments(i: Int): Boolean = true
}

case class ParseArguments(is: Array[Int], colour: Option[Char])
