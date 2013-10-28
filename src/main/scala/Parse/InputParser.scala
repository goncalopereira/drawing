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
}

class InputParser(availableParsers: List[Parser]) {

	private val Separator = ' '

	def apply(input: String, canvas: Option[Canvas]): Option[Command] = {

		val args = input.split(Separator)
     
		availableParsers
			.filter(p => p.Use(args,canvas))
			.map(p => p.Execute(args.tail,canvas))
			.flatten
			.headOption
	}
}
