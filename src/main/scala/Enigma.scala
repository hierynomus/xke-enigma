class Enigma(val reflector: Reflector, val rotors: List[Rotor]) {
  def window : String = rotors.map(_.showing).mkString

  def findPositionOfChar(c: Char): Int = Alphabets.realAlphabet.indexOf(c)

  def rotate(rotors: List[Rotor]) {
    rotors.foldLeft(true)((b, r) => {val n = r.isAtNotch; if (b || n) r.rotate; n})
  }

  def encryptChar(c: Char) = {
    val index: Int = findPositionOfChar(c.toUpper)
    if (index < 0) c
    else {
      rotate(rotors.reverse)
      val i = (rotors.reverse ++ List[{def translate(i: Int): Int}](reflector) ++ rotors.map(_.mirror)).foldLeft(index)((i, p) => p.translate(i))
      Alphabets.realAlphabet.charAt(i)
    }
  }

  def encode(s: String) : String = {
    s.map(encryptChar(_))
  }
}

