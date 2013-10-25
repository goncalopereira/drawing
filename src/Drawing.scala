import Array._

class Canvas {

}

object Canvas {
	def apply(width: Int, length: Int): Array[Array[Char]] = {

		var canvas = ofDim[Char](width,length)

		for (x <- 0 until width) {
			for (y <- 0 until length){
				(x,y) match {
					case(x,_) if (x == 0) || (x == width-1) => canvas(x)(y) = '-'
					case(_,y) if (y == 0) || (y == length-1) => canvas(x)(y)  = '|'
					case (_,_) => canvas(x)(y) = ' '
				}
			}
		}

		return canvas
	}
}

object Drawing {

	def main(args: Array[String]) {

		var canvas = Canvas(6,6)

		for(x <- 0 until canvas.length) {
			for(y <- 0 until canvas(0).length) {
				print(canvas(x)(y))
			}
			println
		}
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