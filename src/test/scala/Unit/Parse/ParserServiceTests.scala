package test.scala.Unit.Parse

import Canvas.Canvas
import Commands.Command
import org.specs2.mutable.Specification
import Parse._
import org.specs2.mock.Mockito


class ParserServiceTests extends Specification with Mockito {

	"Given no parsers" should {

		val parser = new ParserService(List[Parser]())
		val unknown = "X 1 2 3"
		val canvas = new Canvas(5, 5)

		"When string parsed" in {

			val results = parser(unknown, Some(canvas))

			"Return none" in {
				results must beNone
			}
		}
	}

	"Given parser" should {

		"When valid string parsed" in {

			"Return correct command" in {

				var p = mock[Parser]
				val command = mock[Command]

				p = mock[Parser]
				p.CanUse(any[Array[String]]) returns true

				p.Execute(any[Array[String]], any[Option[Canvas]]) returns Right(command)

				val parser = new ParserService(List(p))
				val results = parser("", None)

				results must beSome[Either[String, Command]]
				results.get.isRight mustEqual true
				results.get.right.get mustEqual command
			}
		}

		"When unparsable create command" in {

			"Return error" in {
				var p = mock[Parser]

				p = mock[Parser]
				p.CanUse(any[Array[String]]) returns true
				p.Execute(any[Array[String]], any[Option[Canvas]]) returns Left("error")

				val parser = new ParserService(List(p))
				val results = parser("", None)

				results must beSome[Either[String, Command]]
				results.get.isLeft mustEqual true
			}
		}

		"When sent wrong valid command" in {
			var p = mock[Parser]
			p = mock[Parser]
			p.CanUse(any[Array[String]]) returns false

			"Return none" in {
				val parser = new ParserService(List(p))
				val results = parser("", None)

				results must beNone
			}
		}
	}
}
