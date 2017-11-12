package com.drew.life

import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.paint.Color

object Game extends JFXApp {
  start

  def start: Unit = {
    var lastTime = 0L
    var board = Board(BoardTemplates.standard)
    val gContext = getGContext(board)

    animate(board, gContext)

    val timer = AnimationTimer { now: Long =>
      if (now - lastTime >= 200000000) {
        lastTime = now
        board = board.tick
        println(s"\nticking @ time: ${now}\n")
        animate(board, gContext)
      }
    }
    timer.start
  }

  private def animate(board: Board, gContext: GraphicsContext): Unit = {
    val xBound = board.width
    val yBound = board.height

    for (y <- 0 until yBound) {
      val row: Vector[Cell] = board.cellMatrix(y)
      for (x <- 0 until xBound) {
        val cell = board.cellMatrix(x)(y) // might need to switch these
        val cellGraphic = CellGraphic(x, y, board.width)
        // println(s"""\n
        //   cellGraphic.x: ${cellGraphic.x}\n
        //   cellGraphic.y: ${cellGraphic.y}\n
        //   cellGraphic.cellSize: ${cellGraphic.cellSize}\n""")
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

  private def getGContext(board: Board): GraphicsContext = {
    val canvas = new Canvas(board.width, board.height)
    stage = new JFXApp.PrimaryStage {
      scene = new Scene(Config.boardSideLength, Config.boardSideLength) {
        content = canvas
      }
    }
    val gContext = canvas.graphicsContext2D

    gContext.setFill(Color.BLACK)
    gContext.fillRect(0, 0, Config.boardSideLength, Config.boardSideLength)

    gContext
  }
}
