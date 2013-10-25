import Array._

object Output {
	def Show(canvas: Array[Array[Option[Char]]]) {

		val yLength: Int = canvas(0).length
		val xLength: Int = canvas.length


		for (x <- 0 until xLength) {
			for (y <- 0 until yLength) {

				val o: Option[Char] = canvas(x)(y)

				(x,y) match {
					case(x,_) if (x == 0) || (x == xLength-1) => print('-')
					case(_,y) if (y == 0) || (y == yLength-1) => print('|')
					case (_,_) => print(o)
				}
			}
			println()
		}
	}
}

object Drawing {

	def main(args: Array[String]) {

		val x, y = 6
		var canvas = ofDim[Option[Char]](x,y)

		Output.Show(canvas)
	}
}

class Canvas {

}

trait Command {

}

class CreateCanvas extends Command {

}
class Quit extends Command {

}

class Rectangle extends Command {

}