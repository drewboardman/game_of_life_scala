package com.drew.life

case class Board(val cellMatrix: Vector[Vector[Cell]]) {
  def aliveNeighborCount(x: Int, y: Int): Int = ???
}

object Board {
  def apply(layout: String): Board = {
    val converted: Vector[Vector[Cell]] = convert(layout)
    Board(converted)
  }

  private def convert(layout: String): Vector[Vector[Cell]] = {
    val strMatrix = layout.split("\n").to[Vector]
    for (row <- strMatrix) yield {
      for (strCell <- row) yield {
        Cell.convert(strCell)
      }
    }.to[Vector]
  }
}
