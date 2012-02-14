import collection.mutable.ListBuffer

class Rotor(val leftAlphabet: String, val rightAlphabet: String, val beginPos: Int, val notch: Char) {
  def this(alphabet: String, beginPos: Int) = this(Alphabets.realAlphabet, alphabet, beginPos, 'Z')

  var rotorMap: List[(Char, Char)] = rotate((leftAlphabet zip rightAlphabet).toList, beginPos)

  def isAtNotch = rotorMap.head._1 == notch

  def translateRightToLeft(windowPos: Int) = {
    rotorMap.indexWhere(t => t._1 == rotorMap(windowPos)._2)
  }
  def translateLeftToRight(windowPos: Int) = {
    rotorMap.indexWhere(t => t._2 == rotorMap(windowPos)._1)
  }

  private def rotate(l: List[(Char,  Char)], nr: Int) = {
    val b : ListBuffer[(Char,  Char)] = ListBuffer.empty
    b.appendAll(l.drop(nr))
    b.appendAll(l.take(nr))
    b.toList
  }

  def rotate {
    rotorMap = rotate(rotorMap, 1)
  }
}
