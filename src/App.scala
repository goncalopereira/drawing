import Drawing._
import Fill.BucketFill
import IO.ConsoleOutput
import Shapes._

object App {

	def main(args: Array[String]) {

		val c = new Canvas(20, 4)

		c(LineFactory(1,2,6,2)) = Some(Canvas.Line)

		c(LineFactory(6,3,6,4)) = Some(Canvas.Line)

		c(RectangleFactory(16,1,20,3)) = Some(Canvas.Line)

		c(BucketFill(10,3,'o',c)) = Some('o')

		ConsoleOutput.Print(c)
	}
}

