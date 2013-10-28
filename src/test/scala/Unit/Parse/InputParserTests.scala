package test.scala.Unit.Parse

import Canvas.Canvas
import Commands.{DrawLine, Command, CreateCanvas}
import org.specs2.mutable.Specification
import Parse.InputParser

/*
Need to do same tests for other commands...
 */
class InputParserTests extends Specification {

	val parser = new InputParser(InputParser.Parsers)

	"String with unknown command argument for valid canvas" should {

		val unknown = "X 1 2 3"
		val canvas = new Canvas(5,5)

		"When parsed" in {

			val results = parser(unknown,Some(canvas))

			"Return none" in {
				results must beNone
			}
		}
	}

	"Valid string for CreateCanvas" should {
		val c = "C 2 10"

		"When parsed" in {
			val results = parser(c,None)

		  "Return CreateCanvas Command" in {
			  results must beSome[Command]
			  results.get must beAnInstanceOf[CreateCanvas]
		  }

			"Have correct size" in {
				val r: CreateCanvas = results.get.asInstanceOf[CreateCanvas]
				r.width mustEqual 2
				r.height mustEqual 10
			}
		}
	}

	"String with non parsable argument for CreateCanvas" should {

		val c = "C a 20"

		"When parsed" in {

			val results = parser(c,None)

			"Return none" in {
				results must beNone
			}
		}
	}

	"String with valid Line command" should {

		val c = "L 1 2 1 4"

		"When parsed with no canvas" in {
			val results = parser(c,None)

			"Return none" in {
				results must beNone
			}

			"When parsed with valid canvas" in {
				val canvas = Some(new Canvas(10,10))
				val results = parser(c,canvas)

				"Return Line command" in {
					results must beSome[Command]
					results.get must beAnInstanceOf[DrawLine]
				}
			}
		}
	}
}
