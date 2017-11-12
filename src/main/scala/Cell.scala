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
