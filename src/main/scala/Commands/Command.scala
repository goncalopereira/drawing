package Commands

import Canvas.Canvas

abstract class Command {}

trait Update[T] {
	def Execute()
}

trait Create[T] {
	def Execute(): T
}

abstract class ControlCommand extends Command {}

abstract class CreateCanvasCommand extends Command with Create[Canvas] {}

abstract class UpdateCanvasCommand extends Command with Update[Canvas] {}
