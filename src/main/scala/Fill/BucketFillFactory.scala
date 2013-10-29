package Fill

import Canvas.Canvas

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

	def apply(x: Int, y: Int, colour: Char, canvas: Canvas): Seq[(Int, Int)] = {

		var next = List((x,y))

		val targetColour = canvas(x,y)

		val toColour = List[(Int,Int)]()

		do {

			val point = next.head
			next = next.tail

			if (canvas.IsInternalPosition(point._1,point._2)
				&& canvas(point._1, point._2) == targetColour) {

				toColour :+ point

				val sides = List((point._1-1,point._2),(point._1+1,point._2),(point._1,point._2+1),(point._1,point._2-1))

				val n = sides.filterNot(p => toColour.contains(p))

				next = next ++ n
			}
		} while (next.nonEmpty)

			println("toColour",toColour)
			toColour
		}

}

