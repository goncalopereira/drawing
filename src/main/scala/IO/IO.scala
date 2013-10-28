package IO

trait IO {
	def Print(s: String)
	def Read(message: String): String
}

trait Console {
	def Print(s: String) {
		print(s)
	}

	def Read(message: String): String = {
		Console.readLine(message)
	}
}
