package Parse

import Canvas.Canvas
import Commands.Command

object InputParser {
	val Parsers = List(
		new QuitParser(),
		new FillCanvasParser(),
		new DrawRectangleParser(),
		new DrawLineParser(),
		new CreateCanvasParser())

	val ParsingError = "Parsing error"
	val WrongNumberOfArguments = "Wrong number of Arguments"
	val RequireCanvas = "Requires Canvas"
}

class InputParser(availableParsers: List[Parser]) {

	private val Separator = ' '

	def apply(input: String, canvas: Option[Canvas]): Option[Either[String, Command]] = {

		val args = input.split(Separator)

		availableParsers
			.filter(p => p.Use(args))
			.map(p => p.Execute(args.tail, canvas))
			.headOption
	}
}
