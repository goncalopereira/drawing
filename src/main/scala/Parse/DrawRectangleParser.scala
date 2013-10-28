package Parse

import Canvas.Canvas
import Commands.DrawRectangle

class DrawRectangleParser extends Parser with CanvasRequired {

	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[DrawRectangle] = {
		if (ss.length != 4)
			return None

		var i: Array[Int] = Array[Int]()

		try {
			i = ss.map(_.toInt)
		}
		catch {
			case _ => return None
		}

		Some(new DrawRectangle(i(0), i(1), i(2), i(3), canvas.get))
	}

	def ParserType(t: Char): Boolean = t == 'R'
}
