package Drawing

import Canvas.Canvas
import Commands._
import IO.Output
import Parse.ParserService
import scala.util.control.Breaks
import Registry.Registry

class Drawing(io: Registry.ConsoleService = Registry.consoleService,
              parserService: ParserService = Registry.parserService) {

	private val EnterCommand = Output.NewLine + "enter command: "
	private val CommandNotFound = "Command not found"

	def Run() {
		var command: Option[Either[String, Command]] = None
		var canvas: Option[Canvas] = None

		val loop = new Breaks;

		loop.breakable {
			do {
				val input = io.Read(EnterCommand)

				command = parserService(input, canvas)

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
