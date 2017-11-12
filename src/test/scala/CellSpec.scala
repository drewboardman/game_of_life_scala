package com.drew.life

import org.scalatest.{FunSpec, Matchers}

class CellSpec extends FunSpec with Matchers {
  describe("Cell") {
    describe("convert") {
      it("converts a + to Alive cell") {
        (Cell.convert("+")).shouldEqual(Alive)
      }

      it("converts a - to Dead cell") {
        (Cell.convert("-")).shouldEqual(Dead)
      }
    }
  //   describe("Alive") {
  //     it("creates + symbol to express Alive Cells on the Board") {
  //       (Alive(1,2).symbol).shouldEqual("+")
  //     }
  //   }

  //   describe("Dead") {
  //     it("creates - symbol to express Dead Cells on the Board") {
  //       (Dead(1,2).symbol).shouldEqual("-")
  //     }
  //   }
  }
}
