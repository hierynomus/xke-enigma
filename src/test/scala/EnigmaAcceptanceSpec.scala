import org.scalatest.{FunSpec, BeforeAndAfter}

class EnigmaAcceptanceSpec extends FunSpec with BeforeAndAfter {

  var enigma: Enigma = _
  val plainText = "ENIGMA REVEALED"
  val cipherText = "QMJIDO MZWZJDMG"

  before {
    enigma = new Enigma(new Reflector(Alphabets.reflector), List(new Rotor(Alphabets.alphabetI, 12), new Rotor(Alphabets.alphabetII, 2), new Rotor(Alphabets.alphabetIII, 10)))
  }

  describe("An accepted enigma") {
    it("should encrypt the text") {
      assert(enigma.encode(plainText) === cipherText)
    }

    it("should decrypt the encrypted text") {
      assert(enigma.encode(cipherText) === plainText)
    }
  }
}
