package com.drew.life

sealed trait Cell

final case object Alive extends Cell {
  def liveOrDie(aliveNeighbors: Int): Cell = {
    aliveNeighbors match {
      case x if x < 2 => Dead
      case x if (x == 2) || (x == 3) => Alive
      case x if x > 3 => Dead
    }
  }
}

final case object Dead extends Cell {
  def liveOrDie(aliveNeighbors: Int): Cell = {
    aliveNeighbors match {
      case x if (x == 3) => Alive
      case _ => Dead
    }
  }
}

// this doesn't really need to be in this file
// makes it nice for syntax though
object Cell {
  def convert(symbol: Char) = {
    symbol match {
      case '+' => Alive
      case '-' => Dead
    }
  }
}
