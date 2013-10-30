package IO

trait ConsoleComponent {
	val console: Console

	class Console {
		def Print(s: String) = print (s)

		def Read(message: String) = Console.readLine (message)
	}

}

trait ConsoleServiceComponent {
	this: ConsoleComponent =>
	val consoleService: ConsoleService

	class ConsoleService {
		def Print(s: String) = console.Print (s)

		def Read(message: String) = console.Read (message)
	}

}
