package Drawing

/*
	Protecting direct access to Matrix (Open/Close)
  Option instead of ' ' Char for non-existing to separate IO implementation from value
  using concept of width and height as as matrix is represented by y,x
 */
object Canvas {
	val HorizontalBorder = '-'
	val VerticalBorder = '|'
	val Line = 'x'
}

class Canvas(private val width: Int, private val height: Int) extends Seq[Array[Option[Char]]] {

	private val widthWithBorder = width+2
	private val heightWithBorder = height+2

	private var values = Array.tabulate[Option[Char]](heightWithBorder,widthWithBorder)
	{
		(h,w) => (h,w) match {
			case(h,_) if (h == 0) || (h == heightWithBorder-1) => Some(Canvas.HorizontalBorder)
			case(_,w) if (w == 0) || (w == widthWithBorder-1) =>  Some(Canvas.VerticalBorder)
			case (_,_) =>  None
		}
	}

	def length: Int = width

	def apply(width: Int, height: Int): Option[Char] = return values(height)(width)

	def apply(row: Int): Array[Option[Char]] = return values(row)

	def update(width: Int, height: Int, value: Option[Char]) = values(height)(width) = value

	def iterator: Iterator[Array[Option[Char]]] = return values.iterator
}

