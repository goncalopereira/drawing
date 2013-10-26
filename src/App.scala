import Drawing._

object App {

	def main(args: Array[String]) {

		val c = new Canvas(20, 4)

		Lines(0,0,0,5).foreach {
			case (x,y) => c(x,y) = Some('a')
		}


		println(Lines(0,0,0,5))

		println(Lines(1,0,3,0))

		Output.Print(c)
	}
}

