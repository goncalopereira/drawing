import Array._

object Output {

	def Print(canvas: Array[Array[Option[Char]]]) {
		canvas.foreach(row => {
			row.foreach(p => print(p.getOrElse(' ')))
			println
		})
	}
}

object Canvas {
	def apply(width: Int, height: Int): Array[Array[Option[Char]]] = {

		var v = ofDim[Option[Char]](width,height)

		for (x <- 0 until width; y <- 0 until height) {
			(x,y) match {
				case(x,_) if (x == 0) || (x == width-1) => v(x)(y) = Some('-')
				case(_,y) if (y == 0) || (y == height-1) => v(x)(y)  = Some('|')
				case (_,_) => v(x)(y) = None
			}
		}


		//case(x,_) if (x == 0) || (x == width-1) => canvas(x)(y) = '-'
		//case(_,y) if (y == 0) || (y == length-1) => canvas(x)(y)  = '|'
		//case (_,_) => canvas(x)(y) = ' '

			return v;
	}
}

object Drawing {

	def main(args: Array[String]) {

		val c = Canvas(6, 6)

		Output.Print(c)
	}
}

trait Command {

}

class CreateCanvas extends Command {

}
class Quit extends Command {

}

class Rectangle extends Command {

}