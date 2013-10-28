package IO

class Console extends IO {
	def Print(s: String) {
		print(s)
	}

	def Read(message: String): String = {
		Console.readLine(message)
	}
}
