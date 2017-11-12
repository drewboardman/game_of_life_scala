package com.drew.life

import org.scalatest.{FunSpec, Matchers}

class CellSpec extends FunSpec with Matchers {
  describe("Cell") {
    describe("convert") {
      it("converts a + to Alive cell") {
        (Cell.convert('+')).shouldEqual(Alive)
      }

      it("converts a - to Dead cell") {
        (Cell.convert('-')).shouldEqual(Dead)
      }
    }

    describe("liveOrDie") {
      it("kills cells with fewer than 2 neighbors") {
        val cell = Alive
        (cell.liveOrDie(1)).shouldEqual(Dead)
      }

      it("kills cells with more than 3 neighbors") {
        val cell = Alive
        (cell.liveOrDie(4)).shouldEqual(Dead)
      }

      it("keeps living if 2 or 3 alive neighbors") {
        val cell = Alive
        (cell.liveOrDie(2)).shouldEqual(Alive)
        (cell.liveOrDie(3)).shouldEqual(Alive)
      }

      it("revives Dead cells with exactly 3 neighbors") {
        val cell = Dead
        (cell.liveOrDie(3)).shouldEqual(Alive)
      }

      it("does not revive Dead cells for any other reason") {
        val cell = Dead
        (cell.liveOrDie(1)).shouldEqual(Dead)
        (cell.liveOrDie(4)).shouldEqual(Dead)
      }
    }
  }
}
