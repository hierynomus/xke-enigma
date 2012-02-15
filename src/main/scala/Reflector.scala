class Reflector(val reflection: String) {

  def translate(i: Int) = {
    reflection.zipWithIndex.filter(t => t._1 == reflection.charAt(i) && t._2 != i).head._2
  }

}
