import org.scalatest.{FunSpec, BeforeAndAfter}

/**
 * http://startpad.googlecode.com/hg/labs/js/enigma/enigma-sim.html
 */
class EnigmaAcceptanceSpec extends FunSpec with BeforeAndAfter {

  var enigma: Enigma = _
  val plainText = "ENIGMA REVEALED"
//  val cipherText = "QMJIDO MZWZJDMG"
  val cipherText = "QMJIDO MZWZJFJR" // With real notches, not the Iwein 'Z'

  before {
    enigma = new Enigma(new Reflector(Alphabets.reflector), List(
      new Rotor(Alphabets.realAlphabet, Alphabets.alphabetI, 12, 'E'),
      new Rotor(Alphabets.realAlphabet, Alphabets.alphabetII, 2, 'Q'),
      new Rotor(Alphabets.realAlphabet, Alphabets.alphabetIII, 10, 'V')))
  }

  describe("An accepted enigma") {
    it("should encrypt the text") {
      assert(enigma.encode(plainText) === cipherText)
    }

    it("should decrypt the encrypted text") {
      assert(enigma.encode(cipherText) === plainText)
    }

    it("should assert that Jamie was here") {
      assert(enigma.encode("JamieWasHere") === "MRHGHQPJUZPK")
    }
    it("should also parse a long message") {
      assert(enigma.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ") === "TSNCHBIWPNQFZYVWOSDDKACTQU")
    }

    it("should also parse a very long message") {
      assert(enigma.encode("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ") === "TSNCHBIWPNQFZYVWOSDDKACTQUKFPHMXJPDKPTXWUJUUYYXRRMQK")
    }
  }
}
