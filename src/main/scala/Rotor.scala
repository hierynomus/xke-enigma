import collection.mutable.ListBuffer

class Rotor(var rotorMap: List[(Char, Char)], val notch: Char) {
  def this(alphabet: String, beginPos: Int, notch: Char) = this(Rotor.rotate((Alphabets.realAlphabet zip alphabet).toList, beginPos), notch)
  def this(alphabet: String, beginPos: Int) = this(alphabet, beginPos, 'Z')

  def showing = rotorMap.head._1

  def isAtNotch = rotorMap.head._1 == notch

  def mirror = new Rotor(rotorMap.map(x => (x._2, x._1)), notch)
  
  def translate(windowPos: Int) = {
    rotorMap.indexWhere(t => t._1 == rotorMap(windowPos)._2)
  }

  def rotate {
    rotorMap = Rotor.rotate(rotorMap, 1)
  }
}

object Rotor {
  def rotate(l: List[(Char,  Char)], nr: Int) = {
    val b : ListBuffer[(Char,  Char)] = ListBuffer.empty
    b.appendAll(l.drop(nr))
    b.appendAll(l.take(nr))
    b.toList
  }
}