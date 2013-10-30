package Drawing

import Canvas.Canvas
import Commands._
import IO.Output
import Parse.ParserService
import scala.util.control.Breaks
import Registry.Registry

object Drawing {
	val EnterCommand = Output.NewLine + "enter command: "
	val CommandNotFound = "Command not found"
}

class Drawing(io: Registry.ConsoleService = Registry.consoleService, parserService: ParserService = Registry.parserService) {
	def Run() {
		var command: Option[Either[String, Command]] = None
		var canvas: Option[Canvas] = None

		val loop = new Breaks;

		loop.breakable {
			do {
				val input = io.Read(Drawing.EnterCommand)

				command = parserService(input, canvas)

				command match {
					case None => io.Print(Drawing.CommandNotFound)
					case Some(Left(s)) => io.Print(s)
					case Some(Right(_: Quit)) => loop.break()
					case Some(Right(c: CreateCanvasCommand)) => {
						canvas = Some(c.Execute())
						io.Print(canvas.getOrElse("").toString())
					}
					case Some(Right(c: UpdateCanvasCommand)) => {
						c.Execute()
						io.Print(canvas.getOrElse("").toString())
					}
				}
			} while (true)
		}
	}
}
