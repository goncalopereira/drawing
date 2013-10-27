import Commands._
import Convert.Output
import Drawing.Canvas
import Parse.InputParser

/*
	Only App does IO (read line, print) - These could be moved to an IO package
 */
object App {

	def ShouldQuit(command: Option[Command]): Boolean = {
		command match {
			case None => false
			case Some(c: Quit) => true
			case _ => false
		}
	}

	def ShowOutput(command: Option[Command], canvas: Option[Canvas]): String = {
		(command,canvas) match {
			case (_,None) => ""
			case (Some(c: Quit),_) => ""
			case (_,Some(c)) => Output(c)
		}
	}

	def main(args: Array[String]) {

			var command: Option[Command] = None
			var canvas: Option[Canvas] = None

			do {
					val input = Console.readLine("\nenter command: ")

				  command = InputParser(input)

				  canvas = new CreateCanvas(20,4).Execute()

				  print(ShowOutput(command,canvas))
			  } while (!ShouldQuit(command))

		 new CreateCanvas(20,4).Execute()

		 new DrawLine(1,2,6,2,canvas.get).Execute()

		 new DrawLine(6,3,6,4,canvas.get).Execute()

		 new DrawRectangle(16,1,20,3,canvas.get).Execute()

		 new FillCanvas(10,3,'o',canvas.get).Execute()

	}
}

