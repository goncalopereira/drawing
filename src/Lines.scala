package Drawing

/*
Abstracting line algorithm from Canvas and Draw
KISS because there are only two types of line, more variations could be replaced with Chain of Responsibility
*/
object Lines {
	def apply(x: Int, y: Int, x2: Int, y2: Int): IndexedSeq[(Int,Int)] = {

		if (x == x2) return (y to y2).map {
			case v => (x, v)
		}

		if (y == y2) return (x to x2).map {
			case v => (v, y)
		}

		return IndexedSeq[(Int,Int)]()
	}
}