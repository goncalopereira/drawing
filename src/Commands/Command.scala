package Commands


trait Command {
	def Execute()
}

class CreateCanvas extends Command {
 def Execute() {}
}

class Quit extends Command {
	def Execute() {}
}

class Rectangle extends Command {
	def Execute() {}
 }

class Line extends Command {
	def Execute() {}
}

class Bucket extends Command {
	def Execute() {}
}