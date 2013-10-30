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
  
    val error = "error message"
    val mockIO = mock[Registry.ConsoleService]
    mockIO.Read(Drawing.EnterCommand) returns "stub"

    val mockParserService = mock[ParserService]
 
    "When command not found" in {
      mockParserService(any[String],any[Option[Canvas]]) returns None thenReturns Some(Right(new Quit()))
    
      val drawing = new Drawing(mockIO, mockParserService)
      drawing.Run()
      "Print command not found" in {
        one(mockIO).Print(Drawing.CommandNotFound)
      }
  }
  
    "When parser service returns error" in {
      mockParserService(any[String],any[Option[Canvas]]) returns Some(Left(error)) thenReturns Some(Right(new Quit()))
    
      val drawing = new Drawing(mockIO, mockParserService)
      drawing.Run()
      "Print error" in {
        one(mockIO).Print(error)
      }
    }
    
    "When finding a Update command" in {
      case class mockUpdate extends Command with Update[Canvas] { def Execute() {} }
      val update = mock[mockUpdate]
      mockParserService(any[String],any[Option[Canvas]]) returns Some(Right(update)) thenReturns Some(Right(new Quit()))
      val drawing = new Drawing(mockIO, mockParserService)
      drawing.Run()
      "Call command execute" in {
        one(update).Execute()
      }
      "Print" in {
        one(mockIO).Print("") //no canvas set up..
      } 
     }

    "When finding a Create command" in {
      val canvas = new Canvas(5,5)
      case class mockCreate extends Command with Create[Canvas] { def Execute(): Canvas = { return new Canvas(1,1) } }
      val create = mock[mockCreate]
      create.Execute() returns canvas
      mockParserService(any[String],any[Option[Canvas]]) returns Some(Right(create)) thenReturns Some(Right(new Quit()))
      val drawing = new Drawing(mockIO, mockParserService)
      drawing.Run()
      "Call command execute" in {
        val canvas2 = one(create).Execute()
      }
      "Print new canvas" in {
        one(mockIO).Print(canvas.toString()) 
      } 
     }
  }
}

