package Registry

import Fill.BucketFillFactory
import IO.{ConsoleComponent, ConsoleServiceComponent}
import Parse._
import Shapes.ShapeFactory

object Registry extends ConsoleServiceComponent with ConsoleComponent {
	val console = new Console()
	val consoleService = new ConsoleService()
	val parserService = new ParserService(List(new QuitParser(), new FillCanvasParser(), new DrawRectangleParser(), new DrawLineParser(), new CreateCanvasParser()))
	var shapeService = new ShapeFactory()
	var fillService = new BucketFillFactory()
}
