package Parse

import Canvas.Canvas
import Commands.Command

object InputParserFactory {
	private val AllParsers = List(
		new QuitParser(),
		new FillCanvasParser(),
		new DrawRectangleParser(),
		new DrawLineParser(),
		new CreateCanvasParser())

	def New = new InputParser(AllParsers)
}

object InputParser {
	val ParsingError = "Parsing error"
	val WrongNumberOfArguments = "Wrong number of Arguments"
	val RequireCanvas = "Requires Canvas"

	private val Separator = ' '
}

class InputParser(availableParsers: List[Parser]) {

	def apply(input: String, canvas: Option[Canvas]): Option[Either[String, Command]] = {

		val args = input.split(InputParser.Separator)

		availableParsers
			.filter(p => p.Use(args))
			.map(p => p.Execute(args.tail, canvas))
			.headOption
	}
}
