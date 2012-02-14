import org.scalatest.{BeforeAndAfter, FunSpec}

class EnigmaSpec extends FunSpec with BeforeAndAfter {

  var simpleEnigma: Enigma = _
  
  before {
    simpleEnigma = new Enigma(new Reflector(Alphabets.reflector), List(new Rotor(Alphabets.alphabetIII, 10)))
  }
  
  describe("A simple enigma") {
    it("should find the index of the character to encrypt") {
      assert(simpleEnigma.findPositionOfChar('E') === 4)
    }

    it("should rotate the rotor before it encrypts") {
      assert(simpleEnigma.encryptChar('E') === 'J')
    }

    it("should not encrypt non-alphabet characters") {
      assert(simpleEnigma.encryptChar(' ') === ' ')
    }
  }

  describe("A more complex enigma") {
    it("foo") {

    }
  }
}
