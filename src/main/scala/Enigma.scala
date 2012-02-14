class Enigma(val reflector: Reflector, val rotors: List[Rotor]) {

  def findPositionOfChar(c: Char): Int = Alphabets.realAlphabet.indexOf(c)

  def encryptChar(c: Char) = {
    val index: Int = findPositionOfChar(c)
    if (index < 0) c
    else {
      var i = index
      rotors.last.rotate
      for (rotor <- rotors.reverse) {
        i = rotor.translateRightToLeft(i)
      }
      i = reflector.reflect(i)
      for (rotor <- rotors) {
        i = rotor.translateLeftToRight(i)
      }
      Alphabets.realAlphabet.charAt(i)
    }
  }

  def encode(s: String) = {
    s
  }

}
