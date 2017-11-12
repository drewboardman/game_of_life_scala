package com.drew.life

import scalafx.scene.paint.Color

sealed trait Cell {
  def color: Color
  def liveOrDie(aliveNeighbors: Int): Cell
}

final case object Alive extends Cell {
  val color: Color = Color.YELLOW

  def liveOrDie(aliveNeighbors: Int): Cell = {
    aliveNeighbors match {
      case x if x < 2 => Dead
      case x if (x == 2) || (x == 3) => Alive
      case x if x > 3 => Dead
    }
  }
}

final case object Dead extends Cell {
  val color: Color = Color.BLACK

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
