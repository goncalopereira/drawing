import Commands._

object App {

	def main(args: Array[String]) {

		 var canvas = new CreateCanvas(20,4).Execute()

		 new DrawLine(1,2,6,2,canvas.get).Execute()

		 new DrawLine(6,3,6,4,canvas.get).Execute()

		 new DrawRectangle(16,1,20,3,canvas.get).Execute()

		 new FillCanvas(10,3,'o',canvas.get).Execute()

		 new Quit().Execute()


	}
}

