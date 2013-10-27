package Shapes
/*
Abstracting line algorithm from Canvas and Draw
KISS because there are only two types of line, more variations could be replaced with Chain of Responsibility
No need to make a Line class and no space validation, it's a separate concept from Canvas
Although an empty list is not a line it's just for convenience
*/
object LineFactory {
		def apply(x: Int, y: Int, x2: Int, y2: Int) = {

			(x,y,x2,y2) match {
				case (`x`,_,`x`,_) => (y to y2).map { case v => (x, v) }
				case (_,`y`,_,`y`) => (x to x2).map { case v => (v,y) }
				case _ => Seq[(Int,Int)]()
			}
	}
}

