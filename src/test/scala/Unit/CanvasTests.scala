package Unit.Tests

import Canvas.Canvas
import org.specs2.mutable.Specification

class CanvasTests extends Specification {

  "A width and a length" should {
    val width = 8
    val height = 7

    "When building a Canvas" in {
    
      val canvas = new Canvas(width,height)

      "Have correct width" in {
        canvas(0) must have size(width+2)
      }
      "Have correct height" in {
        canvas must have size(height+2)
      }
      "Print correctly" in {
        canvas.toString mustEqual  """----------
|        |
|        |
|        |
|        |
|        |
|        |
|        |
----------
"""
      }
    }

  }
  
}
