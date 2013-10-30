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
class BucketFillFactory {
	def apply(x: Int, y: Int, canvas: Canvas): Seq[(Int, Int)] = {
		var next: List[(Int, Int)] = List ((x, y))

		val targetColour = canvas (x, y)

		var toColour = List[(Int, Int)]()

		do {
			val point = next.head
			next = next.tail

			val results = Step (point, targetColour, canvas, next, toColour)

			if (results.nonEmpty) {
				toColour = toColour :+ point

				next = next ++ results.get
			}
		} while (next.nonEmpty)

		toColour
	}

	def Step(point: (Int, Int), targetColour: Option[Char], canvas: Canvas, next: Seq[(Int, Int)], toColour: Seq[(Int, Int)]): Option[Seq[(Int, Int)]] = {
		if (canvas.IsInternalPosition (point._1, point._2)
			&& canvas (point._1, point._2) == targetColour) {
			val sides = List ((point._1 - 1, point._2), (point._1 + 1, point._2), (point._1, point._2 + 1), (point._1, point._2 - 1))

			Some (sides.filterNot (p => toColour.contains (p)).filterNot (p => next.contains (p)))
		} else {
			None
		}
	}
}

