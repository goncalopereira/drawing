package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
abstract class Parser {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean

	def IsIncorrectNumberOfArguments(i: Int): Boolean

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command

	def TryParse(ss: Array[String]): Either[Boolean, ParseArguments]

	def Execute(ss: Array[String], canvas: Option[Canvas]): Either[String, Command] = {

		if (IsInvalidCanvas(canvas))
			return Left(ParserService.RequireCanvas)

		if (IsIncorrectNumberOfArguments(ss.length))
			return Left(ParserService.WrongNumberOfArguments)

		val parsing: Either[Boolean, ParseArguments] = TryParse(ss)

		if (parsing.isLeft)
			return Left(ParserService.ParsingError)

		Right(CreateCommand(parsing.right.get, canvas))
	}

	def CanUse(ss: Array[String]): Boolean
}

trait CanvasRequired {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean = canvas.isEmpty
}

trait CanvasNotRequired {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean = false
}

trait OnlyIntArguments {
	def TryParse(ss: Array[String]): Either[Boolean, ParseArguments] = {
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
	def TryParse(ss: Array[String]) = Right(ParseArguments(Array(), None))

	def IsIncorrectNumberOfArguments(i: Int): Boolean = false
}

case class ParseArguments(is: Array[Int], colour: Option[Char])
