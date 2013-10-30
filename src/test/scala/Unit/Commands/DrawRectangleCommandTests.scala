package Unit.Commands

import org.specs2.mutable.Specification
import Commands._
import Shapes._
import org.specs2.mock.Mockito
import Canvas._

class DrawRectangleTests extends Specification with Mockito {
  val service = mock[ShapeFactory]
  
  val line = List((1,1))  

  service.Rectangle(1,2,3,4) returns line

  val canvas = mock[Canvas]

	"DrawRectangleCommand" should {

  val draw = new DrawRectangle(1,2,3,4,canvas,service)
		"When executed" in {
      
      draw.Execute()

      one(service).Rectangle(1,2,3,4)

      "Updates the Canvas" in {  
        one(canvas).update(line, Canvas.Line)
      }
      
		}
	}
}

