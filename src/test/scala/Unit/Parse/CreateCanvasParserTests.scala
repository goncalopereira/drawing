package Unit.Parse

import Commands.CreateCanvas
import org.specs2.mutable.Specification
import Parse.CreateCanvasParser

/*
Has a lot in common with other Parsers...
 */
class CreateCanvasParserTests extends Specification {
	"Given valid string" should {
		val s = "C 5 5"

		"When executed" in {
			val p = new CreateCanvasParser ()
			val results = p.Execute (s.split (" ").tail, None)

			"Return correct command" in {
				results.isRight mustEqual true
				results.right.get.isInstanceOf[CreateCanvas] mustEqual true
			}

			"Return correct use" in {
				p.CanUse (s.split (" ")) mustEqual true
			}
		}
	}
}
