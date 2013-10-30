package test.scala.Integration

import Drawing.Drawing
import org.specs2.mutable.Specification
import org.specs2.mock.Mockito
import Registry.Registry

class DrawingTests extends Specification with Mockito {

	"Given several commands" should {
		"Return correct output to IO" in {
			val screen1 = "----------------------\n|                    |\n|                    |\n|                    |\n|                    |\n----------------------\n"
			val screen2 = "----------------------\n|                    |\n|xxxxxx              |\n|                    |\n|                    |\n----------------------\n"
			val screen3 = "----------------------\n|                    |\n|xxxxxx              |\n|     x              |\n|     x              |\n----------------------\n"
			val screen4 = "----------------------\n|               xxxxx|\n|xxxxxx         x   x|\n|     x         xxxxx|\n|     x              |\n----------------------\n"
			val screen5 = "----------------------\n|oooooooooooooooxxxxx|\n|xxxxxxooooooooox   x|\n|     xoooooooooxxxxx|\n|     xoooooooooooooo|\n----------------------\n"

			val mockedIO = mock[Registry.ConsoleService]

			mockedIO.Read(any[String])
				.returns("C 20 4")
				.thenReturns("L 1 2 6 2")
				.thenReturns("L 6 3 6 4")
				.thenReturns("R 16 1 20 3")
				.thenReturns("B 10 3 o")
				.thenReturns("Q")

			new Drawing(io = mockedIO,parser = Registry.parserService).Run()

			one(mockedIO).Print(screen1)
			one(mockedIO).Print(screen2)
			one(mockedIO).Print(screen3)
			one(mockedIO).Print(screen4)
			one(mockedIO).Print(screen5)
		}
	}
}
