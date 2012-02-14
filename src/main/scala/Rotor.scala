import collection.mutable.ListBuffer

class Rotor(val alphabet: String, val beginPos: Int) {


  var rotorMap: List[(Char, Char)] = rotate((Alphabets.realAlphabet zip alphabet).toList, beginPos)

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
