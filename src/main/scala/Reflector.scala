class Reflector(val reflection: String) {

  def reflect(i: Int) = {
    reflection.zipWithIndex.filter(t => t._1 == reflection.charAt(i) && t._2 != i).iterator.next()._2
  }

}
