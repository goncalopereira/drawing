package Unit.Commands

import org.specs2.mutable.Specification
import Commands._
import Shapes._
import org.specs2.mock.Mockito
import Canvas._
import Registry.Registry
import Parse._
import Drawing._

class DrawingTests extends Specification with Mockito {
  "Using the Drawing application" should {
  
    val mockIO = mock[Registry.ConsoleService]
    val mockParserService = mock[ParserService]

    val drawing = new Drawing(mockIO, mockParserService)
    
    mockIO.Read(Drawing.EnterCommand) returns ""    

    "When command not found" in {
      mockParserService(any[String],any[Option[Canvas]]) returns None
    
      "Print command not found" in {
        one(mockIO).Print(Drawing.CommandNotFound)
      }
    }
  }
}

