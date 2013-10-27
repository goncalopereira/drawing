package Fill

import Drawing.Canvas

/*
http://en.wikipedia.org/wiki/Flood_fill

Flood-fill (node, target-color, replacement-color):
 1. If the color of node is not equal to target-color, return.
 2. Set the color of node to replacement-color.
 3. Perform Flood-fill (one step to the west of node, target-color, replacement-color).
    Perform Flood-fill (one step to the east of node, target-color, replacement-color).
    Perform Flood-fill (one step to the north of node, target-color, replacement-color).
    Perform Flood-fill (one step to the south of node, target-color, replacement-color).
 4. Return.
 */
object BucketFillFactory {

	private def Travel(x: Int, y: Int, colour: Char, canvas: Canvas,
	                   toColour: Seq[(Int,Int)],
	                   toIgnore: Seq[(Int,Int)]):

		(Seq[(Int,Int)],Seq[(Int,Int)]) = {

		if (y >= canvas.length || x >= canvas(0).length || x < 0 || y < 0)
			return (Seq[((Int,Int))] (),Seq[((Int,Int))] ())

		if (toColour.contains((x,y)))
			return (Seq[((Int,Int))] (),Seq[((Int,Int))] ())

		if (toIgnore.contains((x,y)))
			return (Seq[((Int,Int))] (),Seq[((Int,Int))] ())

		canvas(x, y) match {

			case Some(Canvas.HorizontalBorder) => return (Seq[((Int,Int))] (),List((x,y)))
			case Some(Canvas.VerticalBorder) => return (Seq[((Int,Int))] (),List((x,y)))
			case Some(Canvas.Line) => return (Seq[((Int,Int))] (),List((x,y)))
			case Some(colour) => return (Seq[((Int,Int))] (),List((x,y)))

			case _ => {

				var c = toColour ++ List((x,y))
				var i = toIgnore

				val (cWest,iWest) = Travel(x - 1, y, colour, canvas,c,i)
				c = c++cWest
				i = i++iWest

				val (cEast,iEast) = Travel(x + 1, y, colour, canvas,c,i)
				c = c++cEast
				i = i++iEast

				val (cNorth,iNorth) = Travel(x, y+1, colour, canvas,c,i)
				c = c++cNorth
				i = i++iNorth

				val (cSouth,iSouth) = Travel(x, y-1, colour, canvas,c,i)
				c = c++cSouth
				i = i++iSouth
				return (c,i)

			}
		}
	}

	def apply(x: Int, y: Int, colour: Char, canvas: Canvas): Seq[(Int, Int)] = {
	  val (c,_) = Travel(x,y,colour,canvas,Seq[(Int,Int)](),Seq[(Int,Int)]())
		return c
	}
}
