package Commands

import Drawing.Canvas
import Shapes._
import Fill.BucketFill
import OS._

trait Command {
	def Execute() : Option[Canvas]
}

class CreateCanvas(width: Int, height: Int) extends Command {
 def Execute(): Option[Canvas] = {
	 val canvas = new Canvas(width,height)
	 ConsoleOutput(canvas)
	 Some(canvas)
 }
}

class Quit extends Command {
	def Execute(): Option[Canvas] =  {
		Exit()
		None
	}
}

class DrawRectangle(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] =  {
		val points = RectangleFactory(x,y,x2,y2)
	  canvas(points) = Canvas.Line
		ConsoleOutput(canvas)
		None
	}
 }

class DrawLine(x: Int, y: Int, x2: Int, y2: Int, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] =  {
		val points = LineFactory(x,y,x2,y2)
		canvas(points) = Canvas.Line
		ConsoleOutput(canvas)
		Some(canvas)
	}
}

class FillCanvas(x: Int, y: Int, colour: Char, canvas: Canvas) extends Command {
	def Execute(): Option[Canvas] =  {
		val points = BucketFill(x,y,colour,canvas)
		canvas(points) = colour
		ConsoleOutput(canvas)
		Some(canvas)
	}
}