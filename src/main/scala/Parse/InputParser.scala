package Parse

import Commands._
import Drawing.Canvas

/*
Includes all details on string to command
 */
class InputParser {

	val Separator = ' '

	val CreateCanvasArgument = "C"
	val DrawLineArgument = "L"
	val DrawRectangleArgument = "R"
	val FillCanvasArgument = "B"
	val QuitArgument = "Q"

	def CreateCanvas(ss: Array[String]): Option[Command] = {

		if (ss.length != 2)
				return None

		val i = ss.map(_.toInt)

		Some(new CreateCanvas(i(0),i(1)))
	}
	def DrawLine(ss: Array[String], canvas: Canvas): Option[Command] = {
		if (ss.length != 4)
			return None

		val i = ss.map(_.toInt)

		Some(new DrawLine(i(0),i(1),i(2),i(3),canvas))
	}

	def DrawRectangle(ss: Array[String], canvas: Canvas): Option[Command] = {
		if (ss.length != 4)
			return None

		val i = ss.map(_.toInt)

		Some(new DrawRectangle(i(0),i(1),i(2),i(3),canvas))
	}

	def FillCanvas(ss: Array[String],canvas: Canvas): Option[Command] =  {
		if (ss.length != 3)
			return None

		val i1 = ss(0).toInt
		val i2 = ss(1).toInt
		val colour = ss(2).head

		Some(new FillCanvas(i1,i2,colour,canvas))
	}

	def apply(input: String, canvas: Option[Canvas]): Option[Command] = {

	 val args = input.split(Separator)

		(args(0),canvas) match {
			case (CreateCanvasArgument,_) => CreateCanvas(args.tail)
			case (DrawLineArgument,Some(c)) => DrawLine(args.tail,c)
			case (DrawRectangleArgument,Some(c)) => DrawRectangle(args.tail,c)
			case (FillCanvasArgument,Some(c)) => FillCanvas(args.tail,c)
			case (QuitArgument,_) => Some(new Quit())
			case _ => None
		}
	}
}
