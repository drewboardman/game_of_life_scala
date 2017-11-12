package com.drew.life

import org.scalatest.{FunSpec, Matchers}

class CellSpec extends FunSpec with Matchers {
  describe("Cell") {
    describe("Alive") {
      it("creates + symbol to express Alive Cells on the Board") {
        (Alive.symbol).shouldEqual("+")
      }
    }

    describe("Dead") {
      it("creates - symbol to express Dead Cells on the Board") {
        (Dead.symbol).shouldEqual("-")
      }
    }
  }
}
