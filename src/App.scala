import Drawing._

object App {

	def main(args: Array[String]) {

		val c = new Canvas(20, 4)

		Lines(1,2,6,2).foreach {
			case (x,y) => c(x,y) = Some('x')
		}

		Lines(6,3,6,4).foreach {
			case (x,y) => c(x,y) = Some('x')
		}

		Output.Print(c)
	}
}

