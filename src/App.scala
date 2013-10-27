import Commands._
import Drawing._
import Fill.BucketFill
import Shapes._

object App {

	def main(args: Array[String]) {

		 var canvas = new CreateCanvas(20,4).Execute()

		canvas = new Line(1,2,6,2,canvas.get).Execute()

		canvas = new Line(6,3,6,4,canvas.get).Execute()

		canvas = new Rectangle(16,1,20,3,canvas.get).Execute()

		canvas = new Bucket(10,3,'o',canvas.get).Execute()
	}
}

