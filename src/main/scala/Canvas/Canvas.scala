package Canvas

import Convert.Output

/*
	Protecting direct access to Matrix (Open/Close)
  Option instead of ' ' Char for non-existing to separate Convert implementation from value
  using concept of width and height as as matrix is represented by y,x
 */
object Canvas {
	val HorizontalBorder = '-'
	val VerticalBorder = '|'
	val Line = 'x'
}

class Canvas(private val width: Int, private val height: Int) extends Seq[Array[Option[Char]]] {

	private val widthWithBorder = width + 2
	private val heightWithBorder = height + 2

	private val lastHeightPosition = heightWithBorder - 1
	private val lastWidthPosition = widthWithBorder - 1

	private val values = Array.tabulate[Option[Char]](heightWithBorder, widthWithBorder) {
		(h, w) => (h, w) match {
			case (0, _) => Some(Canvas.HorizontalBorder)
			case (`lastHeightPosition`, _) => Some(Canvas.HorizontalBorder)
			case (_, 0) => Some(Canvas.VerticalBorder)
			case (_, `lastWidthPosition`) => Some(Canvas.VerticalBorder)
			case _ => None
		}
	}

	def length: Int = values.length
  
  private def internalPosition(x: Int, y: Int): Boolean = {     
    return (x >= 1 && y >= 1 && x <= width && y <= height)
  }
	def apply(width: Int, height: Int): Option[Char] = {
    
    if (width >= 0 && height >= 0 && width <= widthWithBorder && height <= heightWithBorder) {
      return values(height)(width)
    } 
    else None
  }

	def apply(row: Int): Array[Option[Char]] = return values(row)

	def update(width: Int, height: Int, value: Char) { update(List((width,height)),value) }

	def update(points: Seq[(Int, Int)], value: Char) { 
    val filtered = points.filter(p => internalPosition(p._1,p._2))

    filtered.foreach {
		  case (width, height) => values(height)(width) = Some(value)
	  }
  }

	def iterator: Iterator[Array[Option[Char]]] = return values.iterator

	override def toString(): String = {
		var output: String = ""

		this.foreach(row => {
			output += row.foldLeft("")((line, rowValue) => line + rowValue.getOrElse(Output.EmptyChar)) + Output.NewLine
		})

		output
	}
}

