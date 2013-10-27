import Canvas.Canvas
import Commands._
import Parse.InputParser

/*
	Only App does IO (read line, print) - These could be moved to an IO package
 */
object App {

	def main(args: Array[String]) {

		var command: Option[Command] = None
		var canvas: Option[Canvas] = None
		var running = true

		val parser = new InputParser()

		do {
			val input = Console.readLine("\nenter command: ")

			command = parser(input, canvas)

			command match {
				case Some(c: Quit) => {
					running = false
				}
				case Some(c: CreateCanvas) => {
					canvas = c.Execute()
					print(canvas.get)
				}
				case Some(c: Command) => {
					c.Execute()
					print(canvas.get)
				}
				case _ => {}
			}
		} while (running)
	}
}

