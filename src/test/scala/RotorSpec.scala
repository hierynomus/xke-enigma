import org.scalatest.{BeforeAndAfter, FunSpec}

class RotorSpec extends FunSpec with BeforeAndAfter {

  var rotor: Rotor = _
  
  before {
    rotor = new Rotor(Alphabets.alphabetIII, 10)
  }
  
  describe("A rotor which translates right-to-left") {
    it("should translate a position into its counterpart position") {
      assert(rotor.translateRightToLeft(4) === 14)
    }

    it("should take the alphabet length into account") {
      assert(rotor.translateRightToLeft(17) === 19)
    }
    
    it("should be able to rotate a notch, and translate correctly") {
      rotor.rotate
      assert(rotor.translateRightToLeft(4) === 19)
    }

    it("should be at notch when 'Z' is showing in the window") {
      1.to(14).foreach(_ => rotor.rotate)
      assert(rotor.isAtNotch === false)
      rotor.rotate
      assert(rotor.isAtNotch === true)
    }
  }
  
  describe("A rotor which translates left-to-right") {
    it("should translate a position into its counterpart position") {
      assert(rotor.translateLeftToRight(16) === 9)
    }

    it("should be able to rotate a notch, and translate correctly") {
      rotor.rotate
      assert(rotor.translateLeftToRight(16) === 15)
    }
  }
}
