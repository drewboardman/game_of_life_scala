package com.drew.life

case class Board(layout: String) {
  def generate: Vector[Vector[Cell]] = {
    val grid = layout.split("\n").to[Vector]
    val cellMatrix =
      for (row <- grid) {
        for (strCell <- row) {
          ???
        }
      }
    ???
  }
}

object Board {
}
