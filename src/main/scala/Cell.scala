package com.drew.life

sealed trait Cell {
  def symbol: String
}

final case object Alive extends Cell {
  val symbol = "+"
}

final case object Dead extends Cell {
  val symbol = "-"
}

// this doesn't really need to be in this file
// makes it nice for syntax though
object Cell {
  def convert(str: String) = {
    str match {
      case "+" => Alive
      case "-" => Dead
    }
  }
}
