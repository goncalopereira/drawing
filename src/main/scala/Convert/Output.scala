package Convert

import Drawing.Canvas

object Output {

	val EmptyChar = ' '
	val NewLine = '\n'

	def apply(canvas: Canvas): String = {
		var output: String = ""

		canvas.foreach(row => {
			output += row.foldLeft("") ((line,rowValue) => line+rowValue.getOrElse(EmptyChar))
			output += NewLine
		})

		output
	}
}

