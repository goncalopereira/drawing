package Registry

import IO.{ConsoleComponent, ConsoleServiceComponent}
import Parse._

object Registry extends ConsoleServiceComponent with ConsoleComponent  {
	val console = new Console()
	val consoleService = new ConsoleService()
	val parserService = new InputParser(List(
		new QuitParser(),
		new FillCanvasParser(),
		new DrawRectangleParser(),
		new DrawLineParser(),
		new CreateCanvasParser()))
}
