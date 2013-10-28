package Parse

import Canvas.Canvas
import Commands.FillCanvas

class FillCanvasParser extends Parser with CanvasRequired {
	def Execute(ss: Array[String], canvas: Option[Canvas]): Option[FillCanvas] = {
		if (ss.length != 3)
			return None

		var i1, i2 = 0
		var colour: Char = ' '

		try {
			i1 = ss(0).toInt
			i2 = ss(1).toInt
			colour = ss(2).head
		}
		catch {
			case _ => return None
		}

		Some(new FillCanvas(i1, i2, colour, canvas.get))
	}

	def ParserType(t: String): Boolean = t == "B"
}
