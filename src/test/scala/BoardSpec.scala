package com.drew.life

import org.scalatest.{FunSpec, Matchers}

class BoardSpec extends FunSpec with Matchers {
  describe("Board") {
    val strTemplate = """+-+
                        |---
                        |-+-""".stripMargin

    describe("aliveNeighborCount") {
      it("returns the correct alive neighbor count") {
        val board = Board(strTemplate)
        val countMiddle = board.aliveNeighborCount(1,1)
        val countTopLeft = board.aliveNeighborCount(0,0)
        countMiddle.shouldEqual(3)
        countTopLeft.shouldEqual(0)
      }
    }

    describe("tick") {
    }

    describe("apply") {
      it("takes a string template and converts it to Cells") {
        val generated =
          Vector(
            Vector(Alive, Dead,  Alive),
            Vector(Dead,  Dead,  Dead ),
            Vector(Dead,  Alive, Dead )
          )
        val board = Board(strTemplate)
        (board.cellMatrix).shouldEqual(generated)
        (board.width).shouldEqual(3)
        (board.height).shouldEqual(3)
      }
    }
  }
}
