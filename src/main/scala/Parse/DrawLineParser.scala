package Parse

import Canvas.Canvas
import Commands.DrawLine

class DrawLineParser extends Parser {

	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[DrawLine] = {
		if (ss.length != 4)
			return None

		var i: Array[Int] = Array[Int]()

		try {
			i = ss.map(_.toInt)
		}
		catch {
			case _ => return None
		}

		Some(new DrawLine(i(0), i(1), i(2), i(3), canvas.get))
	}

	def ParserType(t: Char): Boolean = t == 'L'
}