import Drawing.Drawing
import IO.Console
import Parse.InputParserFactory

object App {
	def main(args: Array[String]) {
		new Drawing(new Console,InputParserFactory.New)()
	}
}

