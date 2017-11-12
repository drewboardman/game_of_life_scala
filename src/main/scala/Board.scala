package com.drew.life

case class Board(layout: String) {
  def generate: Vector[Vector[Cell]] = {
    val grid = layout.split("\n").to[Vector]
    for (row <- grid) yield {
      for (strCell <- row) yield {
        Cell.convert(strCell)
      }
    }.to[Vector]
  }
}

object Board {
}
