package Commands

import Drawing.Canvas
import Shapes._
import Fill.BucketFill
import IO.ConsoleOutput

trait Command {
	def Execute() : Option[Canvas]
}

class CreateCanvas(width: Int, height: Int) extends Command {
 def Execute() : Option[Canvas] = {
	 Some(new Canvas(width,height))
 }
}

class Quit extends Command {
	def Execute() : Option[Canvas] = {
		System.exit(1)
		None
	}
}

class Rectangle(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command {
	def Execute() : Option[Canvas] =  {
		val points = RectangleFactory(x,y,x2,y2)
	  canvas(points) = Some(Canvas.Line)
		ConsoleOutput(canvas)
		Some(canvas)
	}
 }

class Line(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command {
	def Execute() : Option[Canvas] = {
		val points = LineFactory(x,y,x2,y2)
		canvas(points) = Some(Canvas.Line)
		ConsoleOutput(canvas)
		Some(canvas)
	}
}

class Bucket(x: Int, y: Int, colour: Char, canvas: Canvas) extends Command {
	def Execute() : Option[Canvas] = {
		val points = BucketFill(x,y,colour,canvas)
		canvas(points) = Some(colour)
		ConsoleOutput(canvas)
		Some(canvas)
	}
}