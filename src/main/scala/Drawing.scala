package Drawing

import Canvas.Canvas
import Commands._
import IO.{Output, IO}
import Parse.InputParser
import scala.util.control.Breaks

class Drawing(io: IO) {

	private val EnterCommand = Output.NewLine + "enter command: "
	private val CommandNotFound = "Command not found"

	def apply() {
		var command: Option[Either[String, Command]] = None
		var canvas: Option[Canvas] = None

		val parser = new InputParser(InputParser.Parsers)

		val loop = new Breaks;

		loop.breakable {
			do {
				val input = io.Read(EnterCommand)

				command = parser(input, canvas)

				command match {
					case None => io.Print(CommandNotFound)

					case Some(Left(s)) => io.Print(s)

					case Some(Right(_: Quit)) => loop.break()

					case Some(Right(c: Create[Canvas])) => {
						canvas = Some(c.Execute())
						io.Print(canvas.get.toString())
					}

					case Some(Right(c: Update[Canvas])) => {
						c.Execute()
						io.Print(canvas.get.toString())
					}
				}

			} while (true)
		}

	}

}
