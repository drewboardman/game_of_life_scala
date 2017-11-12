package com.drew.life

case class CellGraphic(row: Int, column: Int, cellsPerSide: Int) {
  val cellSize: Double = (Config.boardSideLength / cellsPerSide) - Config.padding
  val x: Double = (row.toDouble * cellSize) + Config.padding
  val y: Double = (column.toDouble * cellSize) + Config.padding
}
