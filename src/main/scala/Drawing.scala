package Drawing

import Canvas.Canvas
import Commands.{Quit, Command}
import IO.{Output, IO}
import Parse.InputParser

class Drawing(io: IO) {

	private val EnterCommand = Output.NewLine + "enter command: "
	private val CommandNotFound = "Command not found"

	def apply() {
		var command: Option[Either[String, Command]] = None
		var canvas: Option[Canvas] = None
		var running = true

		val parser = new InputParser(InputParser.Parsers)

		do {
			val input = io.Read(EnterCommand)

			command = parser(input, canvas)

			command match {
				case None => io.Print(CommandNotFound)

				case Some(Left(s)) => io.Print(s)

				case Some(Right(_: Quit)) => running = false

				case Some(Right(c)) => {
					canvas = c.Execute()
					io.Print(canvas.get.toString())
				}
			}

		} while (running)
	}

}
