package Parse

import Canvas.Canvas
import Commands.Command

object ParserService {
	val ParsingError = "Parsing error"
	val WrongNumberOfArguments = "Wrong number of Arguments"
	val RequireCanvas = "Requires Canvas"
	val Separator = ' '
}

class ParserService(availableParsers: List[Parser]) {
	def apply(input: String, canvas: Option[Canvas]): Option[Either[String, Command]] = {
		val args = input.split (ParserService.Separator)

		availableParsers.filter (p => p.CanUse (args)).map (p => p.Execute (args.tail, canvas)).headOption
	}
}
