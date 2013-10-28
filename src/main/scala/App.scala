import Canvas.Canvas
import Commands._
import Parse.InputParser

/*
	Only App does IO (read line, print) - These could be moved to an IO package
 */
object App {

	def main(args: Array[String]) {

		var command: Option[Either[String,Command]] = None
		var canvas: Option[Canvas] = None
		var running = true

		val parser = new InputParser(InputParser.Parsers)

		do {
			val input = Console.readLine("\nenter command: ")

			command = parser(input, canvas)
       
			command match {
        case None => println("Command not found")
        
        case Some(Left(s)) => println(s)

        case Some(Right(_: Quit)) => running = false 
        case Some(Right(c)) => 
          {
            canvas = c.Execute()
            print(canvas.get)               
          }
			}
			
		} while (running)
	}
}

