package test.scala.Unit.Parse

import Canvas.Canvas
import Commands.{DrawLine, Command, CreateCanvas}
import org.specs2.mutable.Specification
import Parse._

/*
Need to do same tests for other commands...
 */
class InputParserTests extends Specification {

	"Given no parsers" should {

	  val parser = new InputParser(List[Parser]())
		val unknown = "X 1 2 3"
		val canvas = new Canvas(5,5)

		"When string parsed" in {

			val results = parser(unknown,Some(canvas))

			"Return none" in {
				results must beNone
			}
		}
	}

  "Given CreateCanvas parser" should {
    val parser = new InputParser(List(new CreateCanvasParser()))
    
    val validCreate = "C 5 5"
    val unparsableCreate = "C a 5"
    val wrongCommand = "L 1 1 1 2"

    "When valid string parsed" in {
      val results = parser(validCreate,None)
      
      "Return correct command" in {
        results must beSome[Command]
      }

    "When unparsable create command" in {
        val results = parser(unparsableCreate,None)
        
        "Return none" in {
          results must beNone
        }
     }

     "When sent wrong valid command" in {
        val results = parser(wrongCommand,None)
        
        "Return none" in {
          results must beNone
        }
      }
      
    }
    
   }
}
