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
  }
}
