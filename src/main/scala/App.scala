import Canvas.Canvas
import Commands._
import IO._
import Parse.InputParser

object App extends IO with Console {

	private val EnterCommand = "\nenter command: "
	private val CommandNotFound = "Command not found"

	def main(args: Array[String]) {

		var command: Option[Either[String, Command]] = None
		var canvas: Option[Canvas] = None
		var running = true

		val parser = new InputParser(InputParser.Parsers)

		do {
			val input = Read(EnterCommand)

			command = parser(input, canvas)

			command match {
				case None => Print(CommandNotFound)

				case Some(Left(s)) => Print(s)

				case Some(Right(_: Quit)) => running = false

				case Some(Right(c)) => {
					canvas = c.Execute()
					Print(canvas.get.toString())
				}
			}

		} while (running)
	}
}

