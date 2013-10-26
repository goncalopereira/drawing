package IO

import Drawing.Canvas

object ConsoleOutput {

	def Print(canvas: Canvas) {
		canvas.foreach(row => {
			row.foreach(p => print(p.getOrElse(' ')))
			println()
		})
	}
}

