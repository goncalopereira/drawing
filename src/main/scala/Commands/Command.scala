package Commands

abstract class Command {}

trait Update[T] {
	def Execute()
}

trait Create[T] {
	def Execute(): T
}

abstract class ControlCommand extends Command {}
