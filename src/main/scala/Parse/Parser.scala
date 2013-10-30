package Parse

import Canvas.Canvas
import Commands.Command

/*
hides details like argument, required to have canvas...
 */
abstract class Parser {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean

	def IsIncorrectNumberOfArguments(numberArguments: Int): Boolean

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command

	def TryParse(ss: Array[String]): Either[Boolean, ParseArguments]

	def Execute(arguments: Array[String], canvas: Option[Canvas]): Either[String, Command] = {
		if (IsInvalidCanvas(canvas))
			return Left(ParserService.RequireCanvas)

		if (IsIncorrectNumberOfArguments(arguments.length))
			return Left(ParserService.WrongNumberOfArguments)

		val parsedArguments: Either[Boolean, ParseArguments] = TryParse(arguments)

		if (parsedArguments.isLeft)
			return Left(ParserService.ParsingError)

		Right(CreateCommand(parsedArguments.right.get, canvas))
	}

	def CanUse(arguments: Array[String]): Boolean
}

trait CanvasRequired {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean = canvas.isEmpty
}

trait CanvasNotRequired {
	def IsInvalidCanvas(canvas: Option[Canvas]): Boolean = false
}

trait OnlyIntArguments {
	def TryParse(arguments: Array[String]): Either[Boolean, ParseArguments] = {
		try {
			val convertedArguments = arguments.map(_.toInt)
			Right(new ParseArguments(convertedArguments, None))
		} catch {
			case _ => return Left(false)
		}
	}
}

trait NoArguments {
	def TryParse(arguments: Array[String]) = Right(ParseArguments(Array(), None))

	def IsIncorrectNumberOfArguments(numberArguments: Int): Boolean = false
}

case class ParseArguments(convertedArguments: Array[Int], colour: Option[Char])
