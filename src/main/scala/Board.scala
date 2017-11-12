package com.drew.life

case class Board(val cellMatrix: Vector[Vector[Cell]]) {
  val height: Int = cellMatrix.size
  val width: Int = cellMatrix.head.size

  def aliveNeighborCount(x: Int, y: Int): Int = {
    val neighbors = List(
      (x-1, y-1), (x, y-1), (x+1, y-1),
      (x-1, y  ),           (x+1, y  ),
      (x-1, y+1), (x, y+1), (x+1, y+1)
    )

    val filteredNeighbors = filterNeighbors(neighbors)

    val toCells = 
      for (neighbor <- filteredNeighbors) yield {
        val (neighborX, neighborY) = neighbor
        cellMatrix(neighborX)(neighborY)
      }

    toCells.filter(_ == Alive).size
  }

  private def filterNeighbors(neighbors: List[(Int,Int)]): List[(Int, Int)] = {
    val xBound = width - 1
    val yBound = height - 1
    neighbors.filter { neighbor =>
        neighbor match {
          case (fx, fy) if (fx < 0) | (fy < 0) => false
          case (fx, fy) if (fx > xBound) | (fy > yBound) => false
          case _ => true
        }
    }
  }
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
