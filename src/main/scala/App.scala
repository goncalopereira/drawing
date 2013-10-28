import Drawing.Drawing
import IO.Console

object App {
	def main(args: Array[String]) {
		new Drawing(new Console)()
	}
}

