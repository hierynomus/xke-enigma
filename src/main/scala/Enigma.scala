class Enigma(val reflector: Reflector, val rotors: List[Rotor]) {

  def findPositionOfChar(c: Char): Int = Alphabets.realAlphabet.indexOf(c)
  
  def rotate(rotors: List[Rotor]) {
    if (rotors.head.isAtNotch) {
      rotate(rotors.tail)
    }
    rotors.head.rotate
  }

  def encryptChar(c: Char) = {
    val index: Int = findPositionOfChar(c)
    if (index < 0) c
    else {
      rotate(rotors.reverse)
      val i = encryptLeftToRight(reflector.reflect(encryptRightToLeft(index, rotors.reverse)), rotors)
      Alphabets.realAlphabet.charAt(i)
    }
  }

  def encode(s: String) : String = {
    s.map(encryptChar(_))
  }

  def encryptRightToLeft(index: Int, rotors: List[Rotor]) : Int = rotors match {
    case x :: xs => encryptRightToLeft(rotors.head.translateRightToLeft(index), rotors.tail)
    case _ => index
  }
  
  def encryptLeftToRight(index: Int,  rotors: List[Rotor]) : Int = rotors match {
    case x :: xs => encryptLeftToRight(rotors.head.translateLeftToRight(index), rotors.tail)
    case _ => index
  }
  
}
