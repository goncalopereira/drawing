package Drawing

class Canvas(private val width: Int, private val height: Int) extends Seq[Array[Option[Char]]] {

	private val widthWithBorder = width+2
	private val heightWithBorder = height+2

	private var values = Array.tabulate[Option[Char]](widthWithBorder,heightWithBorder)
	{
		(x,y) => (x,y) match {
			case(x,_) if (x == 0) || (x == widthWithBorder-1) => Some('-')
			case(_,y) if (y == 0) || (y == heightWithBorder-1) =>  Some('|')
			case (_,_) =>  None
		}
	}

	def length: Int = width

	def apply(x: Int, y: Int): Option[Char] = return values(x)(y)

	def apply(x: Int): Array[Option[Char]] = return values(x)

	def update(x: Int, y: Int, value: Option[Char]) = values(x)(y) = value

	def iterator: Iterator[Array[Option[Char]]] = return values.iterator
}

