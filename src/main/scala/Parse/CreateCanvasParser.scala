package Parse

import Canvas.Canvas
import Commands.CreateCanvas

class CreateCanvasParser extends Parser with CanvasNotRequired {

	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[CreateCanvas] = {
		if (ss.length != 2)
			return None

		var i: Array[Int] = Array[Int]()

		try {
			i = ss.map(_.toInt)
		}
		catch {
			case _ => return None
		}
		Some(new CreateCanvas(i(0), i(1)))
	}

	def ParserType(t: Char): Boolean = t == 'C'
}
