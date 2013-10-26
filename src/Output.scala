package Drawing

object Output {

	def Print(canvas: Canvas) {
		canvas.foreach(row => {
			row.foreach(p => print(p.getOrElse(' ')))
			println()
		})
	}
}

