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
    
    if (args.length == 1)
      return None
     
		availableParsers
			.filter(p => p.ValidCanvas(canvas) && p.ParserType(args.head.head))
			.map(p => p.Execute(args.tail,canvas))
			.flatten
			.headOption
	}
}
