package com.drew.life

case class CellGraphic(row: Int, column: Int, cellsPerSide: Int) {
  val cellSize: Double = (Config.boardSideLength / cellsPerSide) - Config.padding
  val x: Double = (row.toDouble * cellSize)
  val y: Double = (column.toDouble * cellSize)
}
