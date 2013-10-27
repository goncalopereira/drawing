package OS

import Drawing.Canvas

object ConsoleOutput {

	def apply(canvas: Canvas) {

		canvas.foreach(row => {
			row.foreach(p => print(p.getOrElse(' ')))
			println()
		})
	}
}

