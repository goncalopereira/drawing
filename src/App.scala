import Drawing._
import Fill.BucketFill
import IO.ConsoleOutput
import Shapes._

object App {

	def main(args: Array[String]) {

		val c = new Canvas(20, 4)

		LineFactory(1,2,6,2).foreach {
			case (x,y) => c(x,y) = Some('x')
		}

		LineFactory(6,3,6,4).foreach {
			case (x,y) => c(x,y) = Some('x')
		}

		RectangleFactory(16,1,20,3).foreach {
			case (x,y) => c(x,y) = Some('x')
		}

		BucketFill(10,3,'o',c).foreach {
			case (x,y) => c(x,y) = Some('o')
		}

		ConsoleOutput.Print(c)
	}
}

