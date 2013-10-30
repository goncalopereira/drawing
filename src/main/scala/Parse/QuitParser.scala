package Parse

import Canvas.Canvas
import Commands.{Command, Quit}

class QuitParser extends Parser with CanvasNotRequired with NoArguments {
	def CanUse(t: Array[String]): Boolean = t.head == "Q"

	def CreateCommand(parsed: ParseArguments, canvas: Option[Canvas]): Command = new Quit ()
}
