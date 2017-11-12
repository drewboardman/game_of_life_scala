package com.drew.life

import org.scalatest.{FunSpec, Matchers}

class BoardSpec extends FunSpec with Matchers {
  describe("Board") {
    describe("aliveNeighborCount") {
      // ignore("returns the correct alive neighbor count") {
      //   val board = Board(BoardTemplates.standard)
      //   val cell = Alive(2,1)
      //   val count = board.aliveNeighborCount(cell)
      //   count.shouldEqual(2)
      // }
    }

    describe("generate") {
      it("takes a string template and converts it to Cells") {
        val strTemplate = "+-+\n---\n-+-"
        val generated =
          Vector(
            Vector(Alive, Dead,  Alive),
            Vector(Dead,  Dead,  Dead ),
            Vector(Dead,  Alive, Dead )
          )
        (Board(strTemplate).generate).shouldEqual(generated)
      }
    }
  }
}
