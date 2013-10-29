package Parse

import Canvas.Canvas
import Commands.{Command, Quit}

class QuitParser extends Parser with CanvasNotRequired with NoArguments {
	def ParserType(t: String): Boolean = t == "Q"

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command = new Quit()
}
