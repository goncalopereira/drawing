package Parse

import Commands._

object InputParser {

	val Separator = ' '

	def CreateCanvas(ss: Array[String]): Option[Command] = {None}

	def DrawLine(ss: Array[String]): Option[Command] = {None}

	def DrawRectangle(ss: Array[String]): Option[Command] = {None}

	def FillCanvas(ss: Array[String]): Option[Command] = {None}

	def apply(input: String): Option[Command] = {

	 val args = input.split(Separator)

		args(0) match {
			case "C" => CreateCanvas(args)
			case "L" => DrawLine(args)
			case "R" => DrawRectangle(args)
			case "B" => FillCanvas(args)
			case "Q" => Some(new Quit())
			case _ => None
		}
	}

}
