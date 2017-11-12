package com.drew.life

import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.canvas.{Canvas, GraphicsContext}

object Game extends JFXApp {

  def start: Unit = {
    var lastTime = 0L
    var board = Board(BoardTemplates.standard)

    animate(board)

    val timer = AnimationTimer { now: Long =>
      if (now - lastTime >= 200000000) {
        lastTime = now
        board = board.tick
        animate(board)
      }
    }
    timer.start
  }

  private def animate(board: Board): Unit = {
    val canvas = new Canvas(board.width, board.height)
    val gContext = canvas.getGraphicsContext2D
    val xBound = board.width - 1
    val yBound = board.height - 1

    for (y <- 0 until yBound) {
      val row: Vector[Cell] = board.cellMatrix(y)
      for (x <- 0 until xBound) {
        val cell = board.cellMatrix(x)(y) // might need to switch these
        val cellGraphic = CellGraphic(x, y, board.width)
        gContext.setFill(cell.color)
        gContext.fillRect(
          cellGraphic.x,
          cellGraphic.y,
          cellGraphic.cellSize,
          cellGraphic.cellSize
        )
      }
    }
  }
}
